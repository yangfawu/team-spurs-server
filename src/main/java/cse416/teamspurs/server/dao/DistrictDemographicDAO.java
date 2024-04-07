package cse416.teamspurs.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.projection.PopulationBoundsProjection;

@Repository
public class DistrictDemographicDAO {

        @Autowired
        private MongoTemplate template;

        /**
         * Retrieves the lowest and highest population count for a specific group in a
         * state.
         * 
         * @param state the state to retrieve the info from
         * @param group the group to retrieve the info for
         * @return the lowest and highest population count for the specified group in
         *         the specified state
         */
        public PopulationBoundsProjection getPopulationBoundsByStateAndGroup(State state, Group group) {
                // Build the target field name from the group name
                var targetField = String.join(".", "count", group.name());

                var aggregation = Aggregation.newAggregation(
                                // Match the state
                                Aggregation.match(
                                                Criteria.where("state").is(state)),

                                // Compute the min and max of the target field
                                Aggregation.group()
                                                .min(targetField).as("min")
                                                .max(targetField).as("max"));

                // Execute the aggregation
                var results = template.aggregate(
                                aggregation,
                                "district-demographic",
                                PopulationBoundsProjection.class);

                return results.getUniqueMappedResult();
        }

}
