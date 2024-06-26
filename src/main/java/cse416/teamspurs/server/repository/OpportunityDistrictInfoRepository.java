package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.OpportunityDistrictInfo;
import cse416.teamspurs.server.constant.State; 

import java.util.List;

@Repository
public interface OpportunityDistrictInfoRepository extends MongoRepository<OpportunityDistrictInfo, String> {
    public List<OpportunityDistrictInfo> findByStateAndThreshold(State state, Integer threshold);

}
