package tn.kadem.kadem.Services.Contrat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.kadem.kadem.Repository.ContratRepository;
import tn.kadem.kadem.Services.Equipe.EquipeServiceImp;
import tn.kadem.kadem.Services.Etudiant.EtudiantServiceImp;
import tn.kadem.kadem.Services.GServiceImp;
import tn.kadem.kadem.entity.Contrat;
import tn.kadem.kadem.entity.Equipe;
import tn.kadem.kadem.entity.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@EnableScheduling
public class ContratServiceImp extends GServiceImp<Contrat> implements ContraService {
    @Autowired
    EquipeServiceImp equipeServiceImp;
    @Autowired
    EtudiantServiceImp etudiantServiceImp;

    @Autowired
    ContratRepository contratRepository ;
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = this.findById(idContrat);
        Equipe equipe = equipeServiceImp.findById(idEquipe);
        Set<Contrat> sd = new HashSet<>();
        Set<Equipe> se = new HashSet<>();
        sd.add(contrat);
        e.setContrat(sd);
        se.add(equipe);
        e.setEquipe(se);
        etudiantServiceImp.add(e);
        return e;
    }
    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String NomE, String prenomE) {
        Etudiant etudiant = etudiantServiceImp.findByNomAndPrenom(NomE, prenomE);
        if(contratRepository.findContratByEtudiantId(etudiant.getId()).size() < 2) {
            Contrat contrat = this.findById(ce.getId());
            ce.setEtudiant(etudiant);
            this.update(ce);
            return this.findById(ce.getId());
        }else {
            return null;
        }

    }

    @Override
        public Map<Integer,Float> getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = this.retrieveAll();
        Map<Integer,Float> map = new HashMap<>();
        float chiffreAffaire  = 0 ;
        System.out.println(contrats);
        Contrat  contrat = new Contrat();
        for (Contrat c : contrats) {

            Date datedebut = c.getDateDebutContrat();
            Date datefin = c.getDateFinContrat();
            System.out.println(c.getId());
            System.out.println(datedebut.after(startDate) + "/"+ datefin.before(endDate)+"/"+ c.isArchive());
            try {
                if (datedebut.after(startDate) && datefin.before(endDate) && !c.isArchive()) {
                    if (c.getSpecialite().equals("IA")) {
                        map.put(c.getId(),300f);
                    } else if (c.getSpecialite().name().equals("RESEAUX")) {
                        System.out.println(c.getSpecialite());
                        map.put(c.getId(),350f);
                    } else if (c.getSpecialite().name().equals("CLOUD")) {
                        System.out.println(c.getSpecialite());
                        map.put(c.getId(),400f);
                    } else if (c.getSpecialite().equals("SECURITE")) {
                        map.put(c.getId(),450f);
                    }else {
                        System.out.println("no specialite");
                        map.put(c.getId(),0f);
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("null");
            }

        }
        return map;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = this.retrieveAll();
        int nbContratsValides = 0 ;
        for (Contrat c : contrats) {
            Date datedebut = c.getDateDebutContrat();
            Date datefin = c.getDateFinContrat();
            if (!c.isArchive()) {
                nbContratsValides++;
            }
        }
        return nbContratsValides;
    }
    @Override
   @Scheduled(fixedRate = 3000)
    public String retrieveAndUpdateStatusContrat() throws Exception {
        List<Contrat> contrats = this.retrieveAll();
        List<String> contratsValides = new ArrayList<>();
        List<String> contratfini = new ArrayList<>();
        String contrat = "";
        String contratInfo = "" ;
        for (Contrat c : contrats) {
            try {
                Date datefin = c.getDateFinContrat();
                Date today = java.sql.Date.valueOf(java.time.LocalDate.now());
                contratInfo = "Contrat [ " +"\n" +" ContratId :" + c.getId() + " \n" +
                        " dateFin : "+ datefin + " \n"+ " Etudiant : " +c.getEtudiant().getNomE() + " " +
                        "  " +c.getEtudiant().getPrenomE() + "\n"+" Specialite : " + c.getSpecialite() + " ] ";
                if (c.isArchive()) {
                    if (datefin.getTime() - today.getTime() > 15) {
                        contratsValides.add(contratInfo);
                        contrat = contrat.concat("List de Contrat a revoir " + contratsValides.toString()+"\n");
                    }
                }
                boolean b = datefin.compareTo(today) == 0 && LocalDateTime.now().getHour() == 13; ;

                if (b) {
                    contratfini.add(contratInfo);
                    contrat = contrat.concat("List de Contrat fini"+contratfini.toString());
                    c = this.findById(c.getId());
                    c.setArchive(true);
                    this.update(c);
                }
            } catch (NullPointerException e) {
                e.getCause();
               // System.out.println("null");
            }
        }
        Thread.sleep(2000);
        System.out.println(contrat);
        return  contrat;
         }
}



