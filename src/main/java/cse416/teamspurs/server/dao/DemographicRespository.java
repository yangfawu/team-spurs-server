package cse416.teamspurs.server.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.Demographic;

@Repository
public interface DemographicRespository extends MongoRepository<Demographic, ObjectId> {

    public List<Demographic> findByLabel(String label);

    public List<Demographic> findByState(String state);

    public Demographic findByStateAndLabel(String state, String group);

}
