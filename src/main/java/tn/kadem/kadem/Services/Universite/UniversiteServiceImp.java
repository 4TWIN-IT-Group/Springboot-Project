package tn.kadem.kadem.Services.Universite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.kadem.kadem.Services.Departement.DepartementServiceImp;
import tn.kadem.kadem.Services.GServiceImp;
import tn.kadem.kadem.entity.Departement;
import tn.kadem.kadem.entity.Universite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UniversiteServiceImp extends GServiceImp<Universite> implements UniversiteService {

    @Autowired
    DepartementServiceImp departementServiceImp ;

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = this.findById(idUniversite);
        Departement departement = departementServiceImp.findById(idDepartement);
        Set<Departement> sd = new HashSet<>() ;
        System.out.println(departement);
        if(universite !=null && departement != null)
        {
            sd.add(departement);
            universite.setDepartment(sd);
            this.add(universite);
        }
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = this.findById(idUniversite);
        if(universite != null)
        {
            return new ArrayList<>(universite.getDepartment());
        }
        return null;
    }
}

