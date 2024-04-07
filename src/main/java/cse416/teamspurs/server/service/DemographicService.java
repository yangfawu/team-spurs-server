package cse416.teamspurs.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dao.DistrictDemographicDAO;
import cse416.teamspurs.server.model.DistrictDemographic;
import cse416.teamspurs.server.model.StateDemographic;
import cse416.teamspurs.server.projection.PopulationBoundsProjection;
import cse416.teamspurs.server.repository.DistrictDemographicRepository;
import cse416.teamspurs.server.repository.StateDemographicRepository;

@Service
public class DemographicService {

    @Autowired
    private StateDemographicRepository stateRepo;

    @Autowired
    private DistrictDemographicRepository districtRepo;

    @Autowired
    private DistrictDemographicDAO districtDao;

    /**
     * Retrieves the demographic information for a specific state
     * 
     * @param state the state to retrieve the demographic information for
     * @return the demographic information for the specified state
     */
    public Optional<StateDemographic> getStateDemographic(State state) {
        return stateRepo.findByState(state);
    }

    /**
     * Retrieves the demographic information for each district for a specific state
     * 
     * @param state the state to retrieve the demographic information for
     * @return the demographic information for each district in the specified state
     */
    public List<DistrictDemographic> getDistrictDemographicsByState(State state) {
        return districtRepo.findByState(state);
    }

    /**
     * Retrieves the lowest and highest population count for a specific group in a
     * state.
     * 
     * @param state the state to retrieve the info from
     * @param group the group to retrieve the info for
     * @return the lowest and highest population count for the specified group in
     *         the specified state
     */
    public PopulationBoundsProjection getPopulationBoundsByStateAndGroup(State state, Group group) {
        return districtDao.getPopulationBoundsByStateAndGroup(state, group);
    }

}
