package cse416.teamspurs.server.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.Voter;

@Repository
public interface VoterDao extends MongoRepository<Voter, ObjectId> {

    /**
     * Retrieves all voters by party.
     * 
     * @param party the party to retrieve voters from
     * @return a list of voters in the specified party
     */
    public List<Voter> findByParty(String party);

    /**
     * Retrieves all voters by state.
     * 
     * @param state the state to retrieve voters from
     * @return a list of voters
     */
    public List<Voter> findByState(String state);

}
