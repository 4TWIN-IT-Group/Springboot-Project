package tn.kadem.kadem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.kadem.kadem.Services.Contrat.ContratServiceImp;
import tn.kadem.kadem.entity.Contrat;

import java.util.ArrayList;
import java.util.List;

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
        }catch(Exception e){
            System.out.println(e);
            return new ArrayList();
        }
    }
}
