package tn.kadem.kadem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository <T> extends JpaRepository<T, Integer>
{
}
