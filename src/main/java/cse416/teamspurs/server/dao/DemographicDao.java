package cse416.teamspurs.server.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.Demographic;

@Repository
public interface DemographicDao extends MongoRepository<Demographic, ObjectId> {

    /**
     * Retrieves all demographics in a specific state.
     * 
     * @param state the state to retrieve demographics from
     * @return a list of demographics in the specified state
     */
    public List<Demographic> findByState(String state);

    /**
     * Retrieves a demographic by state and group.
     * 
     * @param state the state to retrieve demographics from
     * @param group the group to retrieve demographics from
     * @return a demographic in the specified state and group
     */
    public Demographic findByStateAndLabel(String state, String group);

}
