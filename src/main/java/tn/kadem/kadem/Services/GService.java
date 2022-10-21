package tn.kadem.kadem.Services;

import java.util.List;

public interface GService<T,ID> {
    List retrieveAll();

    void add(T t);

    void update(T t);

    void delete(ID id);

    T getByID(ID id);
}
