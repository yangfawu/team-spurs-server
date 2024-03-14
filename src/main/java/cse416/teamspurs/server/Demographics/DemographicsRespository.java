package cse416.teamspurs.server.Demographics;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DemographicsRespository extends MongoRepository<Demographics, ObjectId>{
    
    public List<Demographics> findByLabel(String label);

    public List<Demographics> findByState(String state);

}
