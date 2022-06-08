package repository;

import domain.Entity;

import java.io.Serializable;
import java.util.List;

public interface IRepository<ID extends Serializable,E extends Entity>{
    E save(E entity);
    void delete(ID id);
    void update(E entity);
    E get(ID id);
    List<E> getAll();
}
