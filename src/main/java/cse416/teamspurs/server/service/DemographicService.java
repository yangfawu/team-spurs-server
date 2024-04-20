package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.DistrictDemographic;
import cse416.teamspurs.server.model.StateDemographic;
import cse416.teamspurs.server.repository.DistrictDemographicRepository;
import cse416.teamspurs.server.repository.StateDemographicRepository;

@Service
public class DemographicService {

    @Autowired
    private StateDemographicRepository stateRepo;

    @Autowired
    private DistrictDemographicRepository districtRepo;

    /**
     * Retrieves the demographic information for a specific state
     * 
     * @param state the state to retrieve the demographic information for
     * @return the demographic information for the specified state
     */
    @Cacheable("state-demo")
    public StateDemographic getStateDemographic(State state) {
        return stateRepo.findByState(state);
    }

    /**
     * Retrieves the demographic information for each district for a specific state
     * 
     * @param state the state to retrieve the demographic information for
     * @return the demographic information for each district in the specified state
     */
    @Cacheable("district-demo")
    public List<DistrictDemographic> getDistrictDemographicsByState(State state) {
        return districtRepo.findByState(state);
    }

}
