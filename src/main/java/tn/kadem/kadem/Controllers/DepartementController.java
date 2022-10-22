package tn.kadem.kadem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.kadem.kadem.Services.Departement.DepartementServiceImp;
import tn.kadem.kadem.entity.Departement;

import java.util.List;

@RestController
public class DepartementController {

    @Autowired
    DepartementServiceImp departementService;

    @GetMapping("/Departements")
    private List<Departement> retrieveAllDepartements() {
        return null;
    }

    @GetMapping("/Departement/{id}")
    private Departement retrieveDepartement(@PathVariable("id") int id) {
        return null;
    }

    @DeleteMapping("/Departement/{id}")
    private void deleteDepartement(@PathVariable("id") int id) {

    }

    @PostMapping("/Departement/add")
    private Departement AddDepartement(@RequestBody Departement departement) {
        return null;
    }

    @PutMapping("/Departement/{id}")
    private Departement updateDepartement(@RequestBody Departement d, @RequestParam int id) {
        return null;
    }
}
