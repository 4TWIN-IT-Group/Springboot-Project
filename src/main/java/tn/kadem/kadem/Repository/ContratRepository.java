package tn.kadem.kadem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.kadem.kadem.entity.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
}
