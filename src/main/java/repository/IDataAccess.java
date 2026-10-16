package repository;

import java.util.List;
import java.util.Optional;

public interface IDataAccess<T> {
    List<T> getAll();
    Optional<T> getById(int id);
    void insert(T entity);
    void update(T entity);
    void delete(int id);
}
