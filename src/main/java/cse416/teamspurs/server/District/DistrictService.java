package cse416.teamspurs.server.District;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repo;

    public List<District> getAllDistrict()
    {
        return repo.findAll();
    }

    public List<District> getDistrictsFrom(String state)
    {
        return repo.findByState(state);
    }

    //return the district in a state with the max value for a group pop
    public Integer getMaxPopFrom(String state, String group)
    {
        switch (group) {
            case "total":
                return repo.getTopTotalPopDistrict(state).getTotalPop();
                
            case "hispanic_latino":
                return repo.getTopLatinoDistrictIn(state).getHispanic_Latino();
            
            case "white":
                return repo.getTopWhiteDistrictIn(state).getWhite();
            
            case "black":
                return repo.getTopBlackDistrictIn(state).getBlack();

            case "american_indian_alaska_native":
                return repo.getTopAlaskaDistrictIn(state).getAlaska();

            case "asian":
                return repo.getTopAsianDistrict(state).getAsian();

            case "hawaiian_pacific_islander":
                return repo.getTopPacificDistrict(state).getHawaiian_pacific_islander();

            case "other":
                return repo.getTopOtherDistrict(state).getOther();

            case "mixed":
                return repo.getTopMixedDistrict(state).getMixed();

            default:
                return repo.getTopTotalPopDistrict(state).getTotalPop();
        }
    }

    //returns the district in a state with the min value for a group pop
    public Integer getMinPopFrom(String state, String group)
    {
        switch (group) {
            case "total":
                return repo.getTopTotalPopDistrict(state).getTotalPop();
                
            case "hispanic_latino":
                return repo.getMinLatinoDistrict(state).getHispanic_Latino();
            
            case "white":
                return repo.getMimWhiteDistrict(state).getWhite();
            
            case "black":
                return repo.getMinBlackDistrict(state).getBlack();

            case "american_indian_alaska_native":
                return repo.getMinAlaskaDistrict(state).getAlaska();

            case "asian":
                return repo.getMinAsianDistrict(state).getAsian();

            case "hawaiian_pacific_islander":
                return repo.getMinPacificDistrict(state).getHawaiian_pacific_islander();

            case "other":
                return repo.getMinOtherDistrict(state).getOther();

            case "mixed":
                return repo.getMinMixedDistrict(state).getMixed();

            default:
                return repo.getMinTotalPopDistrict(state).getTotalPop();
        }
    }
}
