package cse416.teamspurs.server.District;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DistrictRepository extends MongoRepository<District, ObjectId>{

    public List<District> findByState(String state);

    public District findTopByStateOrderByTotalPopulationDesc(String state);

    public District findTopByStateOrderByHispanicLatinoDesc(String state);

    public District findTopByStateOrderByWhiteDesc(String state);

    public District findTopByStateOrderByBlackDesc(String state);

    public District findTopByStateOrderByAmericanIndianAlaskaNativeDesc(String state);

    public District findTopByStateOrderByAsianDesc(String state);

    public District findTopByStateOrderByHawaiianPacificIslanderDesc(String state);

    public District findTopByStateOrderByOtherDesc(String state);

    public District findTopByStateOrderByMixedDesc(String state);
}
