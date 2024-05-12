package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.DistrictDemographic;

@Repository
public interface DistrictDemographicRepository extends MongoRepository<DistrictDemographic, String> {

    public List<DistrictDemographic> findByState(State state);

}
