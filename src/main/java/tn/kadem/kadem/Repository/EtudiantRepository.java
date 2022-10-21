package tn.kadem.kadem.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.kadem.kadem.entity.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {
}
