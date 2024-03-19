package cse416.teamspurs.server.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.District;

@Repository
public interface DistrictDao extends MongoRepository<District, ObjectId> {

        /**
         * Retrieves all districts in a specific state.
         * 
         * @param state the state to retrieve districts from
         * @return a list of districts in the specified state
         */
        @Query
        public List<District> findByState(String state);

        /**
         * Retrieves the district in a state with the highest population for a specific
         * group.
         * 
         * @param state the state to retrieve the district from
         * @param group the group to retrieve the district for
         * @return the district in the specified state with the highest population for
         *         the specified group
         */
        @Aggregation(pipeline = {
                        "{ $match: { 'state' : ?0 } }",
                        "{ $sort: { ?1 : -1 } }",
                        "{ $limit: 1 }"
        })
        public District getDistrictByHighestGroupPopulation(String state, String group);

        /**
         * Retrieves the district in a state with the lowest population for a specific
         * group.
         * 
         * @param state the state to retrieve the district from
         * @param group the group to retrieve the district for
         * @return the district in the specified state with the lowest population for
         *         the specified group
         */
        @Aggregation(pipeline = {
                        "{ $match: { 'state' : ?0 } }",
                        "{ $sort: { ?1 : 1 } }",
                        "{ $limit: 1 }"
        })
        public District getDistrictByLowestGroupPopulation(String state, String group);

}
