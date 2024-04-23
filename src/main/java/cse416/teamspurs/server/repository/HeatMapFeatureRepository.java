package cse416.teamspurs.server.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.HeatLevel;
import cse416.teamspurs.server.model.HeatMapFeature;

@Repository
public interface HeatMapFeatureRepository extends MongoRepository<HeatMapFeature, String> {

    public List<HeatMapFeature> findByStateAndLevel(State state, HeatLevel level);
}
