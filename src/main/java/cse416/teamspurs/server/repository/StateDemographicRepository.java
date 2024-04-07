package cse416.teamspurs.server.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.StateDemographic;

@Repository
public interface StateDemographicRepository extends MongoRepository<StateDemographic, String> {

    public Optional<StateDemographic> findByState(State state);

}
