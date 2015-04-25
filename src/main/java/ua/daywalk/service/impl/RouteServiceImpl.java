package ua.daywalk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.daywalk.domain.Route;
import ua.daywalk.repository.GenericRepository;
import ua.daywalk.repository.RouteRepository;
import ua.daywalk.service.RouteService;


@Service
@Scope("singleton")
public class RouteServiceImpl extends GenericServiceImpl<Route> implements RouteService {

    static final Logger logger = LoggerFactory.getLogger(RouteServiceImpl.class);

    @Autowired
    private RouteRepository routeRepository;

    @Override
    protected GenericRepository<Route> getRepository() {
        return routeRepository;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}
