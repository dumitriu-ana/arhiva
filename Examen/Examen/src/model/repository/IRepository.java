package model.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    T get(int id);
    void update(T t);
    void delete(T t);
    void add(T t);

}
