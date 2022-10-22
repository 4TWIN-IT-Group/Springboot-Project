package tn.kadem.kadem.Services.Contrat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import tn.kadem.kadem.Repository.ContratRepository;
import tn.kadem.kadem.Services.GServiceImp;
import tn.kadem.kadem.entity.Contrat;

import java.util.ArrayList;
import java.util.List;


@Service
public   class ContratServiceImp extends GServiceImp<Contrat> {

//    @Autowired
//    ContratRepository contratRepository ;
//    @Override
//    public List<Contrat> retrieveAll() {
//
//        List<Contrat> t = (List<Contrat>) contratRepository.findAll();
//        return t;
//    }
}



