package tn.kadem.kadem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.kadem.kadem.entity.BaseEntity;

public interface GenericRepository <T extends BaseEntity> extends JpaRepository<T, Integer>
{
}
