package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.StateVoterDistribution;

@Repository
public interface StateVoterDistributionRepository extends MongoRepository<StateVoterDistribution, String> {

    public StateVoterDistribution findByState(State state);

}
