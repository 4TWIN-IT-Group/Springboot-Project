package tn.kadem.kadem.Services;

import java.util.List;

public interface GService<T>  {
         List<T> retrieveAll();
         void add(T t);
        void update(T t);
        void delete(T t);
        T findById(int id);

}
