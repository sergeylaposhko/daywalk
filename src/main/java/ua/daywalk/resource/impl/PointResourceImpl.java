package ua.daywalk.resource.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.daywalk.domain.Point;
import ua.daywalk.resource.PointResource;
import ua.daywalk.service.PointService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/points")
public class PointResourceImpl implements PointResource {

    static final Logger logger = LoggerFactory.getLogger(PointResourceImpl.class);

    @Autowired
    private PointService pointService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Point> findAll() {
        return pointService.findAll();
    }

    @GET
    @Path("{id}")
    public Point findById(String id) {
        return pointService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Point create(Point object) {
        logger.info("Creating point: " + object);
        pointService.create(object);
        return object;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Point update(Point object) {
        logger.info("Updating point: " + object);
        pointService.update(object);
        return object;
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(String id) {
        logger.info("Deleting point: " + id);
        pointService.delete(id);
        return Response.status(200).build();
    }
}
