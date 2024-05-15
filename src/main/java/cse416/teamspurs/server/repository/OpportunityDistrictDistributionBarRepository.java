package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.OpportunityDistrictDistributionBar;

@Repository
public interface OpportunityDistrictDistributionBarRepository
        extends MongoRepository<OpportunityDistrictDistributionBar, String> {

    @Query(sort = "{districts: 1}")
    public List<OpportunityDistrictDistributionBar> findByStateAndGroupAndThreshold(State state, Group group,
            String threshold);

}
