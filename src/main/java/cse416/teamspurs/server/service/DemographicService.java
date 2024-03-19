package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dao.DemographicDao;
import cse416.teamspurs.server.model.Demographic;

@Service
public class DemographicService {
    @Autowired
    private DemographicDao repo;

    /**
     * Retrieves all demographic information from the database
     * 
     * @return a list of all demographic information in the database
     */
    public List<Demographic> getAllDemographics() {
        return repo.findAll();
    }

    /**
     * Retrieves the demographic information for a specific state
     * 
     * @param state the state to retrieve the demographic information for
     * @return the demographic information for the specified state
     */
    public List<Demographic> getDemographicsByState(State state) {
        var mongoState = state.getLabel();
        return repo.findByState(mongoState);
    }

    /**
     * Retrieves the demographic information for a specific state and group
     * 
     * @param state the state to retrieve the district from
     * @param group the group to retrieve the district for
     * @return the demographic information for the specified state and group
     */
    public Demographic getDemographicByStateAndGroup(State state, Group group) {
        var mongoState = state.getLabel();
        var mongoGroup = group.getLabel();
        return repo.findByStateAndLabel(mongoState, mongoGroup);
    }

}
