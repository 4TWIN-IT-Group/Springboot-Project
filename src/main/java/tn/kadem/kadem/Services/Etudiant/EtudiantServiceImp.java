package tn.kadem.kadem.Services.Etudiant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.kadem.kadem.Repository.EtudiantRepository;
import tn.kadem.kadem.Services.Departement.DepartementServiceImp;
import tn.kadem.kadem.Services.GServiceImp;
import tn.kadem.kadem.entity.Departement;
import tn.kadem.kadem.entity.Etudiant;

import java.util.List;


@Service
public class EtudiantServiceImp extends GServiceImp<Etudiant> implements EtudiantService{

    @Autowired
    DepartementServiceImp departementServiceImp ;
    @Autowired
    EtudiantRepository etudiantRepository ;
    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {

        Etudiant etudiant = this.findById(etudiantId);
        Departement departement = departementServiceImp.findById(departementId);
        System.out.println(departement);
        if(etudiant !=null && departement != null)
        {
            etudiant.setDepartment(departement);
            this.add(etudiant);
        }
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        Departement departement = departementServiceImp.findById(idDepartement);
        if(departement != null)
        {
           return etudiantRepository.findByDepartment(departement);
        }
        return null;
    }


    public Etudiant findByNomAndPrenom(String nomE, String prenomE) {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        Etudiant et = new Etudiant();
        for (Etudiant e : etudiants) {
            if (e.getNomE().equals(nomE) && e.getPrenomE().equals(prenomE)) {
                et = e;
                return et;
            }
        }
        return et ;
    }

}
