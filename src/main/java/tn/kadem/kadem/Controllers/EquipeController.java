package tn.kadem.kadem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.kadem.kadem.Services.Equipe.EquipeServiceImp;
import tn.kadem.kadem.entity.Equipe;

import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    EquipeServiceImp equipeService ;

    @GetMapping("/all")
    private List<Equipe> retrieveAllEquipes(){
        return  equipeService.retrieveAll();
    }

    @GetMapping("/{id}")
    private Equipe retrieveEquipe(@PathVariable("id") int id ){
        return equipeService.findById(id);
    }

    @DeleteMapping
    private  void deleteEquipe(@RequestBody Equipe equipe){
        equipeService.delete(equipe);
    }
    @PostMapping("/add")
    private Equipe AddEquipe(@RequestBody Equipe equipe ){
        equipeService.add(equipe);
        return equipe;
    }
    @PutMapping()
    private  Equipe updateEquipe (@RequestBody Equipe e ){
        equipeService.update(e);
        return  e ;
    }
}
