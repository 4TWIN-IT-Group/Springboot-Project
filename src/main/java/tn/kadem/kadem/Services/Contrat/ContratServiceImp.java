package tn.kadem.kadem.Services.Contrat;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.kadem.kadem.Repository.BaseEntityRepository;
import tn.kadem.kadem.Repository.ContratRepository;
import tn.kadem.kadem.Services.GServiceImp;

import java.util.List;


@Service

public class ContratServiceImp<Contrat> extends GServiceImp<Contrat,Integer> {

    @Autowired
    ContratRepository contratRepository;

    public ContratServiceImp(BaseEntityRepository<Contrat, Integer> baseEntityRepository) {
        super(baseEntityRepository);
    }


    @Override
    public void add(Contrat o) {
        super.add(o);
    }

    @Override
    public List<Contrat> retrieveAll() {
        return super.retrieveAll();
    }

    @Override
    public void update(Contrat o) {
        super.update(o);
    }




}
