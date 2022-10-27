package tn.kadem.kadem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import tn.kadem.kadem.entity.Contrat;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface ContratRepository extends GenericRepository<Contrat> {
    List<Contrat> findContratByEtudiantId(Integer id);

}
