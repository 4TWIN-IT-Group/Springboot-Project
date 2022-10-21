package tn.kadem.kadem.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.kadem.kadem.Repository.BaseEntityRepository;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
public class GServiceImp<T,ID> implements GService<T,ID> {

    BaseEntityRepository <T,ID> baseEntityRepository ;

    @Override
    public List retrieveAll() {
        List t = new ArrayList();
        baseEntityRepository.findAll().forEach(e -> t.add(e));
        return t;
    }


    public void add(T o) {
        baseEntityRepository.save(o);
    }


    public void update(T o) {
        baseEntityRepository.save(o);
    }

    @Override
    public void delete(ID id) {
        baseEntityRepository.deleteById(id);
    }

    @Override
    public T getByID(ID id) {
    return  baseEntityRepository.getById(id);
    }


}
