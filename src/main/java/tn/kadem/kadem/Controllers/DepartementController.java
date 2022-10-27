package tn.kadem.kadem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.kadem.kadem.Services.Contrat.ContratServiceImp;
import tn.kadem.kadem.Services.Departement.DepartementServiceImp;
import tn.kadem.kadem.entity.Contrat;
import tn.kadem.kadem.entity.Departement;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Departement")
public class DepartementController {

    @Autowired
    DepartementServiceImp departementServiceImp;

    @GetMapping("/all")
    public List<Departement> getAll() {
        try {
            System.out.println("here");
            return departementServiceImp.retrieveAll();
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList();
        }
    }

    @PostMapping
    public Departement addContrat(@RequestBody Departement departement) {
        departementServiceImp.add(departement);
        return departement;
    }

    @PutMapping
    public Departement updateContrat(@RequestBody Departement departement) {
        departementServiceImp.update(departement);
        return departement;
    }

    @DeleteMapping
    public void deleteContrat(@RequestBody Departement departement) {
        departementServiceImp.delete(departement);
    }

    @GetMapping("/{id}")
    public Departement getContratById(@PathVariable(value ="id")int id) {
        return departementServiceImp.findById(id);
    }
}
