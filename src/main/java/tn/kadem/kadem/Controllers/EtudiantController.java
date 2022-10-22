package tn.kadem.kadem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.kadem.kadem.Services.Etudiant.EtudiantServiceImp;
import tn.kadem.kadem.entity.Etudiant;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    EtudiantServiceImp etudiantService;
    
    @GetMapping("/all")
    private List<Etudiant> retrieveAllEtudiants() {
        try {
            System.out.println("here");
            List<Etudiant> list = new ArrayList();
            list =  etudiantService.retrieveAll();
            return list ;
        }catch(Exception e){

            System.out.println(e);
            return new ArrayList();
        }    }
//
//    @GetMapping("/etudiant/{id}")
//    private Etudiant retrieveEtudiant(@PathVariable("id") int id ){
//        return etudiantService.getEtudiantById(id);
//    }
//
//    @DeleteMapping("/etudiant/{id}")
//    private  void deleteEtudiant(@PathVariable("id")int id){
//        etudiantService.delete(id);
//    }
//    @PostMapping("/etudiant/add")
//    private Etudiant AddEtudiant(@RequestBody Etudiant etudiant , @RequestBody Option o){
//        etudiantService.add(etudiant , o);
//        return etudiant;
//    }
//    @PutMapping("/etudiant/{id}")
//     private  Etudiant updateEtudiant (@RequestBody Etudiant e ,@RequestParam int id){
//        etudiantService.update(e,id);
//        return  e ;
//    }
//    @PostMapping("/etudiant/A&A")
//    private Etudiant addAndAssignEtudiant(@RequestBody Etudiant e, @RequestBody Option o, @RequestBody  Departement d)
//    {
//        e.setOption(o);
//        e.setDepartement(d);
//        etudiantService.addAndAssignEtudiant(e ,o ,d);
//        return e ;
//    }
}
