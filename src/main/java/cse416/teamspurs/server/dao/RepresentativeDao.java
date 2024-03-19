package cse416.teamspurs.server.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.Representative;

@Repository
public interface RepresentativeDao extends MongoRepository<Representative, ObjectId> {

    /**
     * Retrieves all representatives by party.
     * 
     * @param party the party to retrieve representatives from
     * @return a list of representatives in the specified party
     */
    public List<Representative> findByParty(String party);

    /**
     * Retrieves all representatives by race.
     * 
     * @param race the race to retrieve representatives from
     * @return a list of representatives
     */
    @Query("{ $or: [{'race': ?0}, {'race2': ?0} ]}")
    public List<Representative> findByRace(String race);

    /**
     * Retrieves all representatives by state.
     * 
     * @param state the state to retrieve representatives from
     * @return a list of representatives
     */
    public List<Representative> findByState(String state);

}
