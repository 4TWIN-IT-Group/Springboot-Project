package tn.kadem.kadem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.kadem.kadem.Repository.GenericRepository;
import tn.kadem.kadem.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;
@Configuration
public  class GServiceImp<T extends BaseEntity> implements GService<T>  {

    @Autowired
    protected GenericRepository<T> genericRepository ;

    @Override
    public List<T> retrieveAll() {
       return  genericRepository.findAll();

    }


}
