package cse416.teamspurs.server.Representatives;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepRepository extends MongoRepository<Reps, ObjectId> {
    public List<Reps> findByParty(String party);

    public List<Reps> findByRace(String race);

    public List<Reps> findByRace2(String race);

    public List<Reps> findByState(String state);
}
