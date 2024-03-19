package cse416.teamspurs.server.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import cse416.teamspurs.server.model.VAGeoJson;

public interface VAGeoJsonDao extends MongoRepository<VAGeoJson, ObjectId> {

}
