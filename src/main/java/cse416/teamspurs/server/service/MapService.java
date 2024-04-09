package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dto.HeatMapDTO;
import cse416.teamspurs.server.model.DistrictGeoJson;
import cse416.teamspurs.server.model.StateGeoJson;
import cse416.teamspurs.server.repository.DistrictGeoJsonRepository;
import cse416.teamspurs.server.repository.StateGeoJsonRepository;

@Service
public class MapService {

    @Autowired
    private DistrictGeoJsonRepository districtRepo;

    @Autowired
    private StateGeoJsonRepository stateRepo;

    @Autowired
    private DemographicService demoService;

    /**
     * Retrieves the GEOJSON for all states.
     * 
     * @return the GeoJson for all states
     */
    @Cacheable("states")
    public List<StateGeoJson> getAllStates() {
        return stateRepo.findAll();
    }

    /**
     * Retrieves the GEOJSON for the state's assembly districts.
     * 
     * @param state the state to retrieve the GeoJson for
     * @return the GeoJson for the specified state
     */
    @Cacheable("assembly-districts")
    public List<DistrictGeoJson> getRegularDistrictMapByState(State state) {
        return districtRepo.findByState(state);
    }

    /**
     * Retrieves the GEOJSON for the state's assembly districts with a heat value
     * based on a group's demographics for each district.
     * 
     * @param state the state to retrieve the GeoJson for
     * @param group the group to calculate the heat value for
     * @return the GeoJson for the specified state with a heat value based on the
     *         specified group demographics
     */
    @Cacheable("heated-assembly-districts")
    public HeatMapDTO getHeatDistrictMapByStateAndGroup(State state, Group group) {
        var bounds = demoService.getPopulationBoundsByStateAndGroup(state, group);
        var min = bounds.getMin();
        var max = bounds.getMax();

        var features = districtRepo.findByStateAndGroup(state, group);

        return new HeatMapDTO(min, max, features);
    }

}
