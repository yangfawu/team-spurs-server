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
    public int getMaxPopulationByStateAndGroup(State state, Group group) {
        var mongoState = state.getLabel();
        var mongoGroup = group.getLabel();
        var district = repo.getDistrictByHighestGroupPopulation(mongoState, mongoGroup);
        return district.getCount();
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
    public int getMinPopulationByStateAndGroup(State state, Group group) {
        var mongoState = state.getLabel();
        var mongoGroup = group.getLabel();
        var district = repo.getDistrictByLowestGroupPopulation(mongoState, mongoGroup);
        return district.getCount();
    }
}
