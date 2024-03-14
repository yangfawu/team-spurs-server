package cse416.teamspurs.server.Demographics;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemographicsRespository extends MongoRepository<Demographics, ObjectId>{

}
