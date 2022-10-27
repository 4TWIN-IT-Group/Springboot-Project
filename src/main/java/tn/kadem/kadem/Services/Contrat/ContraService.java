package tn.kadem.kadem.Services.Contrat;

import tn.kadem.kadem.entity.Contrat;
import tn.kadem.kadem.entity.Etudiant;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ContraService {
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,
                                                     Integer idEquipe);
    Contrat affectContratToEtudiant (Contrat ce, String NomE, String prenomE);
     Map<Integer,Float> getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) ;

    Integer nbContratsValides(Date startDate, Date endDate);

    String retrieveAndUpdateStatusContrat() throws InterruptedException, Exception;

}
