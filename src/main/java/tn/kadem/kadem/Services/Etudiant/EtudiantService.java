package tn.kadem.kadem.Services.Etudiant;

import tn.kadem.kadem.entity.Contrat;
import tn.kadem.kadem.entity.Etudiant;

import java.util.List;

public interface EtudiantService {
    void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) ;
    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
}
