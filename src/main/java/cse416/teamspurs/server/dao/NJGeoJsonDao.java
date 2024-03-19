package cse416.teamspurs.server.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import cse416.teamspurs.server.model.NJGeoJson;

public interface NJGeoJsonDao extends MongoRepository<NJGeoJson, ObjectId> {

}
