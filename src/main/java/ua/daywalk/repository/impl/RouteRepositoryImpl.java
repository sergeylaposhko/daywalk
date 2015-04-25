package ua.daywalk.repository.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ua.daywalk.domain.Route;
import ua.daywalk.repository.RouteRepository;

import java.util.List;

@Repository
@Scope("singleton")
public class RouteRepositoryImpl implements RouteRepository {

    private static final Logger logger = LoggerFactory.getLogger(RouteRepositoryImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Route> findAll() {
        return mongoTemplate.findAll(Route.class);
    }

    @Override
    public Route findById(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), Route.class);
    }

    @Override
    public void create(Route object) {
        mongoTemplate.insert(object);
    }

    @Override
    public void update(Route object) {
        mongoTemplate.save(object);
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), Route.class);
    }

    @Override
    public void createCollection() {
        if (!mongoTemplate.collectionExists(Route.class)) {
            mongoTemplate.createCollection(Route.class);
        }
    }

    @Override
    public void dropCollection() {
        if (mongoTemplate.collectionExists(Route.class)) {
            mongoTemplate.dropCollection(Route.class);
        }
    }
}
