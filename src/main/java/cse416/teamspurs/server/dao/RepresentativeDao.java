package cse416.teamspurs.server.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.Representative;

@Repository
public interface RepresentativeDao extends MongoRepository<Representative, ObjectId> {
    public List<Representative> findByParty(String party);

    public List<Representative> findByRace(String race);

    public List<Representative> findByRace2(String race);

    public List<Representative> findByState(String state);
}
