package cse416.teamspurs.server.District;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DistrictRepository extends MongoRepository<District, ObjectId>{

    public List<District> findByState(String state);

    //public District findTopByStateOrderByTotalPopulationDesc(String state);

    @Aggregation(pipeline = {"{ $match: { 'state' : ?0 } }", 
                            "{$sort: { 'hispanic_latino' : -1 }}",
                            "{$limit: 1}"})
    public District getTopLatinoDistrictIn(String state);

    @Aggregation(pipeline = {"{ $match: { 'state' : ?0 } }", 
                            "{$sort: { 'white' : -1 }}",
                            "{$limit: 1}"})
    public District getTopWhiteDistrictIn(String state);

    @Aggregation(pipeline = {"{ $match: { 'state' : ?0 } }", 
                            "{$sort: { 'black' : -1 }}",
                            "{$limit: 1}"})
    public District getTopBlackDistrictIn(String state);

    @Aggregation(pipeline = {"{ $match: { 'state' : ?0 } }", 
                            "{$sort: { 'american_indian_alaska_native' : -1 }}",
                            "{$limit: 1}"})
    public District getTopAlaskaDistrictIn(String state);

    // public District findTopByStateOrderByAsianDesc(String state);

    // public District findTopByStateOrderByHawaiianPacificIslanderDesc(String state);

    // public District findTopByStateOrderByOtherDesc(String state);

    // public District findTopByStateOrderByMixedDesc(String state);
}
