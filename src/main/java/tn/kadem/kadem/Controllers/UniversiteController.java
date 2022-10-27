package tn.kadem.kadem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.kadem.kadem.Services.Universite.UniversiteServiceImp;
import tn.kadem.kadem.entity.Departement;
import tn.kadem.kadem.entity.Etudiant;
import tn.kadem.kadem.entity.Universite;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Universite")
public class UniversiteController {

    @Autowired
    UniversiteServiceImp universiteServiceImp ;

    @GetMapping("/all")
    public List<Universite> getAll() {
        try {
            System.out.println("here");
            return universiteServiceImp.retrieveAll();
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList();
        }
    }

    @PostMapping
    public Universite add(@RequestBody Universite universite) {
        universiteServiceImp.add(universite);
        return universite;
    }

    @PutMapping
    public Universite update(@RequestBody Universite universite) {
        universiteServiceImp.update(universite);
        return universite;
    }

    @DeleteMapping
    public void delete(@RequestBody Universite universite) {
        universiteServiceImp.delete(universite);
    }

    @GetMapping("/{id}")
    public Universite getById(@RequestParam(value ="id")int id) {
        return universiteServiceImp.findById(id);
    }

    @PostMapping("Assigne/{idU}/{idD}")
    private Universite AddandAssigne(@PathVariable(value = "idU") Integer idU, @PathVariable(value = "idD") Integer idD){
        universiteServiceImp.assignUniversiteToDepartement(idU,idD);
        return universiteServiceImp.findById(idU);
    }
    @GetMapping("Departements/{id}")
    private List<Departement> getDepartements(@PathVariable(value = "id") Integer id){
        return universiteServiceImp.retrieveDepartementsByUniversite(id);
    }
}
