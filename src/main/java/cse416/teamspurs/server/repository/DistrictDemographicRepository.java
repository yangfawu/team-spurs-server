package cse416.teamspurs.server.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.DistrictDemographic;

@Repository
public interface DistrictDemographicRepository extends MongoRepository<DistrictDemographic, ObjectId> {

        @Query(sort = "{ 'district': 1 }")
        public List<DistrictDemographic> findByState(State state);

}
