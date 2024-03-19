package cse416.teamspurs.server.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.Voter;

@Repository
public interface VoterRepository extends MongoRepository<Voter, ObjectId> {
    public List<Voter> findByParty(String party);

    public List<Voter> findByState(String state);

}
