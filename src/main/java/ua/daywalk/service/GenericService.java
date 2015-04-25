package ua.daywalk.service;

import java.util.List;

public interface GenericService<T> {

    public List<T> findAll();

    public T findById(String id);

    public void create(T person);

    public void update(T person);

    public void delete(String id);

    public void createCollection();

    public void dropCollection();

}
