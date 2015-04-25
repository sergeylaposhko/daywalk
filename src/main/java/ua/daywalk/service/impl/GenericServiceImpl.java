package ua.daywalk.service.impl;


import org.slf4j.Logger;
import ua.daywalk.repository.GenericRepository;
import ua.daywalk.service.GenericService;

import java.util.List;

public abstract class GenericServiceImpl<T> implements GenericService<T> {

    protected abstract GenericRepository<T> getRepository();

    protected abstract Logger getLogger();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(String id) {
        return getRepository().findById(id);
    }

    @Override
    public void create(T object) {
        getRepository().create(object);
    }

    @Override
    public void update(T object) {
        getRepository().update(object);
    }

    @Override
    public void delete(String id) {
        getRepository().delete(id);
    }

    @Override
    public void createCollection() {
        getRepository().createCollection();
    }

    @Override
    public void dropCollection() {
        getRepository().dropCollection();
    }
}
