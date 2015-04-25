package ua.daywalk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.daywalk.domain.Point;
import ua.daywalk.repository.GenericRepository;
import ua.daywalk.repository.PointRepository;
import ua.daywalk.service.PointService;


@Service
@Scope("singleton")
public class PointServiceImpl extends GenericServiceImpl<Point> implements PointService {

    static final Logger logger = LoggerFactory.getLogger(PointServiceImpl.class);

    @Autowired
    private PointRepository pointRepository;


    @Override
    protected GenericRepository<Point> getRepository() {
        return pointRepository;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}
