package cse416.teamspurs.server.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.VoterStat;

@Repository
public interface VoterStatRepository extends MongoRepository<VoterStat, String> {

    public Optional<VoterStat> findByState(State state);

}
