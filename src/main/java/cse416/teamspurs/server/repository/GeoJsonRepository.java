package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.GeoJson;

@Repository
public interface GeoJsonRepository extends MongoRepository<GeoJson, String> {

    public List<GeoJson> findByState(State state);

}
