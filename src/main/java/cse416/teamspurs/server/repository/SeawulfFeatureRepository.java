package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.SeawulfFeature;

@Repository
public interface SeawulfFeatureRepository extends MongoRepository<SeawulfFeature, String> {

    public List<SeawulfFeature> findByPlan(Integer plan);

}