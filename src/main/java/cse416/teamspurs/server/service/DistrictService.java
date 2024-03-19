package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dao.DistrictDao;
import cse416.teamspurs.server.model.District;

@Service
public class DistrictService {

    @Autowired
    private DistrictDao repo;

    /**
     * Retrieves all districts in a specific state.
     * 
     * @param state the state to retrieve districts from
     * @return a list of districts in the specified state
     */
    public List<District> getDistrictsByState(State state) {
        var mongoState = state.getLabel();
        var result = repo.findByState(mongoState);
        result.sort((a, b) -> a.getDistrictId().compareTo(b.getDistrictId()));
        return result;
    }

    /**
     * Retrieves the district in a state with the highest population for a specific
     * group
     * 
     * @param state the state to retrieve the district from
     * @param group the group to retrieve the district for
     * @return the district in the specified state with the highest population for
     *         the specified group
     */
    public Integer getMaxPopulationByStateAndGroup(State state, Group group) {
        var mongoState = state.getLabel();
        var mongoGroup = group.getLabel();
        var district = repo.getDistrictByHighestGroupPopulation(mongoState, mongoGroup);

        switch (group) {
            case HISPANIC_LATINO:
                return district.getHl();
            case WHITE:
                return district.getWhite();
            case BLACK:
                return district.getBlack();
            case AMERICAN_INDIAN_ALASKA_NATIVE:
                return district.getAian();
            case ASIAN:
                return district.getAsian();
            case HAWAIIAN_PACIFIC_ISLANDER:
                return district.getHpi();
            case OTHER:
                return district.getOther();
            case MIXED:
                return district.getMixed();
            default:
                throw new IllegalStateException();
        }
    }

    /**
     * Retrieves the district in a state with the lowest population for a specific
     * group.
     * 
     * @param state the state to retrieve the district from
     * @param group the group to retrieve the district for
     * @return the district in the specified state with the lowest population for
     *         the specified group
     */
    public Integer getMinPopulationByStateAndGroup(State state, Group group) {
        var mongoState = state.getLabel();
        var mongoGroup = group.getLabel();
        var district = repo.getDistrictByLowestGroupPopulation(mongoState, mongoGroup);

        switch (group) {
            case HISPANIC_LATINO:
                return district.getHl();
            case WHITE:
                return district.getWhite();
            case BLACK:
                return district.getBlack();
            case AMERICAN_INDIAN_ALASKA_NATIVE:
                return district.getAian();
            case ASIAN:
                return district.getAsian();
            case HAWAIIAN_PACIFIC_ISLANDER:
                return district.getHpi();
            case OTHER:
                return district.getOther();
            case MIXED:
                return district.getMixed();
            default:
                throw new IllegalStateException();
        }
    }
}
