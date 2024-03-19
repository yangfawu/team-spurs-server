package cse416.teamspurs.server.Voter;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VoterRepository extends MongoRepository<Voter, ObjectId> {
    public List<Voter> findByParty(String party);

    public List<Voter> findByState(String state);

}
