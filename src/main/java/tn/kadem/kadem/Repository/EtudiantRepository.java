package tn.kadem.kadem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import tn.kadem.kadem.entity.Etudiant;

public interface EtudiantRepository extends GenericRepository<Etudiant> {
}

