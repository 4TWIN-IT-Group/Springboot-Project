package tn.kadem.kadem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import tn.kadem.kadem.entity.Departement;
import tn.kadem.kadem.entity.Etudiant;

import java.util.List;

public interface EtudiantRepository extends GenericRepository<Etudiant> {
    List<Etudiant> findByDepartment(Departement departement);
}

