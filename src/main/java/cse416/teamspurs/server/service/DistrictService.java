package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.dao.DistrictRepository;
import cse416.teamspurs.server.model.District;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repo;

    public List<District> getAllDistrict() {
        return repo.findAll();
    }

    public List<District> getDistrictsFrom(String state) {
        return repo.findByState(state);
    }

    // return the district in a state with the max value for a group pop
    public Integer getMaxPopFrom(String state, String group) {
        switch (group) {
            case "total":
                return repo.getTopTotalPopDistrict(state).getTotal();
            case "hispanic_latino":
                return repo.getTopLatinoDistrictIn(state).getHl();
            case "white":
                return repo.getTopWhiteDistrictIn(state).getWhite();
            case "black":
                return repo.getTopBlackDistrictIn(state).getBlack();

            case "american_indian_alaska_native":
                return repo.getTopAlaskaDistrictIn(state).getAian();
            case "asian":
                return repo.getTopAsianDistrict(state).getAsian();
            case "hawaiian_pacific_islander":
                return repo.getTopPacificDistrict(state).getHpi();
            case "other":
                return repo.getTopOtherDistrict(state).getOther();
            case "mixed":
                return repo.getTopMixedDistrict(state).getMixed();
            default:
                return repo.getTopTotalPopDistrict(state).getTotal();
        }
    }

    // returns the district in a state with the min value for a group pop
    public Integer getMinPopFrom(String state, String group) {
        switch (group) {
            case "total":
                return repo.getTopTotalPopDistrict(state).getTotal();

            case "hispanic_latino":
                return repo.getMinLatinoDistrict(state).getHl();
            case "white":
                return repo.getMimWhiteDistrict(state).getWhite();
            case "black":
                return repo.getMinBlackDistrict(state).getBlack();

            case "american_indian_alaska_native":
                return repo.getMinAlaskaDistrict(state).getAian();

            case "asian":
                return repo.getMinAsianDistrict(state).getAsian();

            case "hawaiian_pacific_islander":
                return repo.getMinPacificDistrict(state).getHpi();

            case "other":
                return repo.getMinOtherDistrict(state).getOther();

            case "mixed":
                return repo.getMinMixedDistrict(state).getMixed();
            default:
                return repo.getMinTotalPopDistrict(state).getTotal();
        }
    }
}
