package tn.kadem.kadem.Services.Etudiant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import tn.kadem.kadem.Repository.EtudiantRepository;
import tn.kadem.kadem.Services.GServiceImp;
import tn.kadem.kadem.entity.Contrat;
import tn.kadem.kadem.entity.Etudiant;

import java.util.List;

@Service
public    class EtudiantServiceImp extends GServiceImp<Etudiant>{

//    @Autowired
//    EtudiantRepository etudiantRepository ;
//
//    @Override
//    public List<Etudiant> retrieveAll() {
//        List<Etudiant> t  = (List<Etudiant>) etudiantRepository.findAll();
//        return t ;
//    }
}
