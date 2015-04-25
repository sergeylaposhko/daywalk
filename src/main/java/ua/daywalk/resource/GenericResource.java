package ua.daywalk.resource;

import javax.ws.rs.core.Response;
import java.util.List;

public interface GenericResource<T> {

    public List<T> findAll();

    public T findById(String id);

    public T create(T object);

    public T update(T object);

    public Response delete(String id);
}
