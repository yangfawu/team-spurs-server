package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.VoterStat;

@Repository
public interface VoterStatRepository extends MongoRepository<VoterStat, String> {

    public VoterStat findByState(State state);

}
