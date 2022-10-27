package tn.kadem.kadem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.kadem.kadem.Repository.GenericRepository;

import java.util.List;
public  class GServiceImp<T> implements GService<T>  {

    @Autowired
    public GenericRepository<T> genericRepository ;

    @Override
    public List<T> retrieveAll() {
       return  genericRepository.findAll();

    }

    @Override
    public void add(T t) {
        genericRepository.save(t);
    }

    @Override
    public void update(T t) {
        System.out.println("update");
        genericRepository.save(t);
    }

    @Override
    public void delete(T t) {
        genericRepository.delete(t);
    }

    @Override
    public T findById(int id) {
        return  genericRepository.findById(id).get();
    }


}
