package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dao.DistrictDao;
import cse416.teamspurs.server.model.District;
import cse416.teamspurs.server.model.ExtremeDistrictProjection;

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
     * Retrieves the lowest and highest population count for a specific group in a
     * state.
     * 
     * @param state the state to retrieve the district from
     * @param group the group to retrieve the district for
     * @return the lowest and highest population count for the specified group in
     *         the specified state
     */
    public ExtremeDistrictProjection getExtremeByStateAndGroup(State state, Group group) {
        var mongoState = state.getLabel();
        var mongoGroup = group.getLabel();
        return repo.getExtremeDistrictByStateAndGroup(mongoState, mongoGroup);
    }

}
