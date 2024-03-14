package cse416.teamspurs.server.Representatives;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirginaRepRepository extends MongoRepository<VirginaReps, ObjectId> {

}
