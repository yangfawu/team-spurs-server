package cse416.teamspurs.server.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.BaseDistrict;
import cse416.teamspurs.server.model.District;
import cse416.teamspurs.server.model.ExtremeDistrictProjection;

@Repository
public interface DistrictDao extends MongoRepository<BaseDistrict, ObjectId> {

        /**
         * Retrieves all districts in a specific state.
         * 
         * @param state the state to retrieve districts from
         * @return a list of districts in the specified state
         */
        @Query
        public List<District> findByState(String state);

        /**
         * Retrieves the lowest and highest population count for a specific group in a state.
         * @param state the state to retrieve the info from
         * @param group the group to retrieve the info for
         * @return the lowest and highest population count for the specified group in the specified state
         */
        @Aggregation(pipeline = {
                        "{ $match: { state: ?0 } }",
                        "{ $group: { _id: null, min: { $min: '$?1' }, max: { $max: '$?1' } } }",
        })
        public ExtremeDistrictProjection getExtremeDistrictByStateAndGroup(String state, String group);

}
