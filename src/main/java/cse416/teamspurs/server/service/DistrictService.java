package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dao.DistrictDao;
import cse416.teamspurs.server.model.District;

@Service
public class DistrictService {
    @Autowired
    private DistrictDao repo;

    public List<District> getAllDistrict() {
        return repo.findAll();
    }

    public List<District> getDistrictsFrom(State state) {
        var mongoState = state.getLabel();
        return repo.findByState(mongoState);
    }

    // return the district in a state with the max value for a group pop
    public Integer getMaxPopFrom(State state, String group) {
        var mongoState = state.getLabel();
        switch (group) {
            case "total":
                return repo.getTopTotalPopDistrict(mongoState).getTotal();
            case "hispanic_latino":
                return repo.getTopLatinoDistrictIn(mongoState).getHl();
            case "white":
                return repo.getTopWhiteDistrictIn(mongoState).getWhite();
            case "black":
                return repo.getTopBlackDistrictIn(mongoState).getBlack();
            case "american_indian_alaska_native":
                return repo.getTopAlaskaDistrictIn(mongoState).getAian();
            case "asian":
                return repo.getTopAsianDistrict(mongoState).getAsian();
            case "hawaiian_pacific_islander":
                return repo.getTopPacificDistrict(mongoState).getHpi();
            case "other":
                return repo.getTopOtherDistrict(mongoState).getOther();
            case "mixed":
                return repo.getTopMixedDistrict(mongoState).getMixed();
            default:
                return repo.getTopTotalPopDistrict(mongoState).getTotal();
        }
    }

    // returns the district in a state with the min value for a group pop
    public Integer getMinPopFrom(State state, String group) {
        var mongoState = state.getLabel();
        switch (group) {
            case "total":
                return repo.getTopTotalPopDistrict(mongoState).getTotal();

            case "hispanic_latino":
                return repo.getMinLatinoDistrict(mongoState).getHl();
            case "white":
                return repo.getMimWhiteDistrict(mongoState).getWhite();
            case "black":
                return repo.getMinBlackDistrict(mongoState).getBlack();

            case "american_indian_alaska_native":
                return repo.getMinAlaskaDistrict(mongoState).getAian();

            case "asian":
                return repo.getMinAsianDistrict(mongoState).getAsian();

            case "hawaiian_pacific_islander":
                return repo.getMinPacificDistrict(mongoState).getHpi();

            case "other":
                return repo.getMinOtherDistrict(mongoState).getOther();

            case "mixed":
                return repo.getMinMixedDistrict(mongoState).getMixed();
            default:
                return repo.getMinTotalPopDistrict(mongoState).getTotal();
        }
    }
}
