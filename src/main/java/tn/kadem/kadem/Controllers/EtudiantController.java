package tn.kadem.kadem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.kadem.kadem.Services.Etudiant.EtudiantServiceImp;
import tn.kadem.kadem.entity.Contrat;
import tn.kadem.kadem.entity.Etudiant;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    EtudiantServiceImp etudiantService;

    @GetMapping("/all")
    private List<Etudiant> getAll() {
        return etudiantService.retrieveAll();
    }
    @GetMapping("/{id}")
    private Etudiant retrieveEtudiant(@PathVariable(value ="id")Integer id) {
     return etudiantService.findById(id);
    }
    @PostMapping("/add")
    private Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.add(etudiant);
        return etudiant;
    }
    @PutMapping
    private Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.update(etudiant);
        return etudiant;
    }
    @DeleteMapping
    private void deleteEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.delete(etudiant);
    }

    @PostMapping("Assigne/{idE}/{idD}")
    private Etudiant AddandAssigne(@PathVariable(value = "idE") Integer idE,@PathVariable(value = "idD") Integer idD){
        etudiantService.assignEtudiantToDepartement(idE,idD);
        return etudiantService.findById(idE) ;
    }
    @GetMapping("List/{idD}")
    private List<Etudiant> getEtudiantsByDepartement(@PathVariable(value = "idD") Integer idD){
        return etudiantService.getEtudiantsByDepartement(idD);
    }

}
