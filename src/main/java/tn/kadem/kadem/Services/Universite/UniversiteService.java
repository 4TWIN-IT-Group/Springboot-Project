package tn.kadem.kadem.Services.Universite;

import tn.kadem.kadem.entity.Departement;

import java.util.List;

public interface UniversiteService {
    void assignUniversiteToDepartement(Integer idUniversite, Integer
            idDepartement);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) ;
}
