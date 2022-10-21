package tn.kadem.kadem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import tn.kadem.kadem.entity.BaseEntity;


@NoRepositoryBean
public interface BaseEntityRepository<T,ID> extends JpaRepository<T,ID> {
}