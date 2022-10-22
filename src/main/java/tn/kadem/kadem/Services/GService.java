package tn.kadem.kadem.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.kadem.kadem.entity.BaseEntity;

import java.util.List;

public interface GService<T extends BaseEntity>  {
    List<T> retrieveAll();
}
