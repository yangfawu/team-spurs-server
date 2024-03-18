package cse416.teamspurs.server.District;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

// import org.springframework.data.mongodb.core.MongoOperations;
// import org.springframework.data.mongodb.core.aggregation.Aggregation;
// import org.springframework.data.mongodb.core.aggregation.AggregationResults;
// import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repo;

    // @Autowired
    // private MongoOperations mongoOperations;

    public List<District> getAllDistrict()
    {
        return repo.findAll();
    }

    public List<District> getDistrictsFrom(String state)
    {
        return repo.findByState(state);
    }

    public Integer getMaxPopFrom(String state, String group)
    {
        return repo.getTopWhiteDistrictIn(state).getWhite();
    }

    // public Integer getMaxPopFrom(String state, String group)
    // {
    //     switch (group) {
    //         case "total":
    //             return repo.findTopByStateOrderByTotalPopulationDesc(state).getTotalPop();
                
    //         case "hispanic_latino":
    //             return repo.findTopByStateOrderByHispanicLatinoDesc(state).getHispanic_Latino();
            
    //         case "white":
    //             return repo.findTopByStateOrderByWhiteDesc(state).getWhite();
            
    //         case "black":
    //             return repo.findTopByStateOrderByBlackDesc(state).getBlack();

    //         case "american_indian_alaska_native":
    //             return repo.findTopByStateOrderByAmericanIndianAlaskaNativeDesc(state).getAlaska();

    //         case "asian":
    //             return repo.findTopByStateOrderByAsianDesc(state).getAsian();

    //         case "hawaiian_pacific_islander":
    //             return repo.findTopByStateOrderByHawaiianPacificIslanderDesc(state).getHawaiian_pacific_islander();

    //         case "other":
    //             return repo.findTopByStateOrderByOtherDesc(state).getOther();

    //         case "mixed":
    //             return repo.findTopByStateOrderByMixedDesc(state).getMixed();

    //         default:
    //             return repo.findTopByStateOrderByTotalPopulationDesc(state).getTotalPop();
    //     }
    // }

    // public Integer getMaxWhiteFrom(String state)
    // {
    //     Aggregation aggregation = Aggregation.newAggregation(
    //             Aggregation.match(Criteria.where("state").is(state)),
    //             Aggregation.group().max("white").as("maxPopulation")
    //     );

    //     AggregationResults<MaxPopulationResult> results = mongoOperations.aggregate(
    //         aggregation, "district-demographic", MaxPopulationResult.class);

    //     if (results.getUniqueMappedResult() != null) {
    //         return results.getUniqueMappedResult().getMaxPopulation();
    //     } else {
    //         return 0; // Or any default value indicating no result found
    //     }

    // }

    //private static class MaxPopulationResult {
    //     private int maxPopulation;

    //     public int getMaxPopulation() {
    //         return maxPopulation;
    //     }

    //     public void setMaxPopulation(int maxPopulation) {
    //         this.maxPopulation = maxPopulation;
    //     }
    // }
}
