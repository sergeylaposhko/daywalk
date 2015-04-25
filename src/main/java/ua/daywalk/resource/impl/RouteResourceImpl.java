package ua.daywalk.resource.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.daywalk.domain.Route;
import ua.daywalk.resource.RouteResource;
import ua.daywalk.service.RouteService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/routes")
public class RouteResourceImpl implements RouteResource {

    static final Logger logger = LoggerFactory.getLogger(PointResourceImpl.class);

    @Autowired
    private RouteService routeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Route> findAll() {
        return routeService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Route findById(String id) {
        return routeService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Route create(Route object) {
        logger.info("Create route: " + object);
        routeService.create(object);
        return object;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Route update(Route object) {
        logger.info("Update route: " + object);
        routeService.update(object);
        return object;
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(String id) {
        logger.info("Deleting route: " + id);
        routeService.delete(id);
        return Response.status(200).build();
    }
}
