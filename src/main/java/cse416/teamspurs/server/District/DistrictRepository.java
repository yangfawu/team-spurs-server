package cse416.teamspurs.server.District;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DistrictRepository extends MongoRepository<District, ObjectId>{

    public List<District> findByState(String state);

    public List<District> findByStateIncludeAllButState(String state);

}
