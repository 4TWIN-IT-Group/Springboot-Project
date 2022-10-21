package tn.kadem.kadem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.kadem.kadem.Services.Contrat.ContratServiceImp;
import tn.kadem.kadem.entity.Contrat;

import java.util.List;

@RestController
public class ContratController {

    @Autowired
    ContratServiceImp contratService;

    @GetMapping("/contrats")
    private List<Contrat> retrieveAllContrats() {
        return contratService.retrieveAll();
    }
//
//    @DeleteMapping("/contrat/{id}")
//    private  void deleteContrat(@PathVariable("id")int id){
//        contratService.delete(id);
//    }
//    @PostMapping("/contrat/add")
//    private Contrat AddContrat(@RequestBody Contrat contrat ){
//        contratService.add(contrat);
//        return contrat;
//    }
//    @PutMapping("/contrat/{id}")
//    private  Contrat updateContrat (@RequestBody Contrat c , @PathVariable(value = "id") int id){
//        contratService.update(c,id);
//        return  c ;
//    }

}
