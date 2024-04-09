package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.StateGeoJson;

@Repository
public interface StateGeoJsonRepository extends MongoRepository<StateGeoJson, String> {

}