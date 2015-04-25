package ua.daywalk.repository;


import java.util.List;

public interface GenericRepository<T> {

    public List<T> findAll();

    public T findById(String id);

    public void create(T object);

    public void update(T object);

    public void delete(String id);

    public void createCollection();

    public void dropCollection();
}
