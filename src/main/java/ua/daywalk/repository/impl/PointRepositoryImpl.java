package ua.daywalk.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ua.daywalk.domain.Point;
import ua.daywalk.repository.PointRepository;

import java.util.List;


@Repository
@Scope("singleton")
public class PointRepositoryImpl implements PointRepository {

    private static final Logger logger = LoggerFactory.getLogger(PointRepositoryImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Point> findAll() {
        return mongoTemplate.findAll(Point.class);
    }

    @Override
    public Point findById(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), Point.class);
    }

    @Override
    public void create(Point object) {
        mongoTemplate.insert(object);
    }

    @Override
    public void update(Point object) {
        mongoTemplate.save(object);
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), Point.class);
    }

    @Override
    public void createCollection() {
        if (!mongoTemplate.collectionExists(Point.class)) {
            mongoTemplate.createCollection(Point.class);
        }
    }

    @Override
    public void dropCollection() {
        if (mongoTemplate.collectionExists(Point.class)) {
            mongoTemplate.dropCollection(Point.class);
        }
    }
}
