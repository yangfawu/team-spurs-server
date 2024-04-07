package cse416.teamspurs.server.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.Representative;

@Repository
public interface RepresentativeRepository extends MongoRepository<Representative, ObjectId> {

    // public List<Representative> findByParty(String party);

    // @Query("{ $or: [{'race': ?0}, {'race2': ?0} ]}")
    // public List<Representative> findByRace(String race);

    public List<Representative> findByState(State state);

}
