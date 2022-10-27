package tn.kadem.kadem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.kadem.kadem.Services.Contrat.ContratServiceImp;
import tn.kadem.kadem.entity.Contrat;
import tn.kadem.kadem.entity.Etudiant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    ContratServiceImp contratServiceImp;

    @GetMapping("/all")
    public List<Contrat> getAll() {
        try {
            System.out.println("here");
            return contratServiceImp.retrieveAll();
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList();
        }
    }

    @PostMapping
    public Contrat add(@RequestBody Contrat contrat) {
        contratServiceImp.add(contrat);
        return contrat;
    }

    @PutMapping
    public Contrat update(@RequestBody Contrat contrat) {
        contratServiceImp.update(contrat);
        return contrat;
    }

    @DeleteMapping
    public void delete(@RequestBody Contrat contrat) {
        contratServiceImp.delete(contrat);
    }

    @GetMapping("/{id}")
    public Contrat getById(@RequestParam(value ="id")int id) {
        return contratServiceImp.findById(id);
    }

    @PostMapping("Assigne/{idU}/{idD}")
    public Etudiant assigne(@RequestBody Etudiant etudiant,@PathVariable(value = "idU") Integer idU, @PathVariable(value = "idD") Integer idD){
        contratServiceImp.addAndAssignEtudiantToEquipeAndContract(etudiant,idU,idD);
        return etudiant ;
    }
    @PostMapping("Affect/{NomE}/{prenomE}")
    public Contrat affect(@RequestBody Contrat contrat, @PathVariable(value = "NomE") String NomE, @PathVariable(value = "prenomE") String prenomE){
        contratServiceImp.affectContratToEtudiant(contrat,NomE,prenomE);
        return contrat ;
    }
    @GetMapping("ChiffreAffaire/{date1}/{date2}")
    public Map<Integer,Float> chiffreAffaire(@PathVariable(value = "date1") String date1, @PathVariable(value = "date2") String date2) throws ParseException {
        Date startDate = Date.valueOf(date1);
        Date endDate = Date.valueOf(date2);
        return contratServiceImp.getChiffreAffaireEntreDeuxDate(startDate,endDate);

    }
    @GetMapping("nbrContrat/{date1}/{date2}")
    public Integer nbContratsValides(@PathVariable(value = "date1") String date1, @PathVariable(value = "date2") String date2)
    {
        Date startDate = Date.valueOf(date1);
        Date endDate = Date.valueOf(date2);
        return contratServiceImp.nbContratsValides(startDate,endDate);
    }
    @GetMapping("status")
    public String retrieveAndUpdateStatusContrat() throws Exception {
        return contratServiceImp.retrieveAndUpdateStatusContrat();
    }



}

