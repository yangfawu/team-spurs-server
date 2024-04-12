package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.GeoJson;
import cse416.teamspurs.server.model.GroupStateBound;
import cse416.teamspurs.server.repository.GeoJsonRepository;
import cse416.teamspurs.server.repository.GroupStateBoundRepository;

@Service
public class MapService {

    @Autowired
    private GeoJsonRepository geoJsonRepo;

    @Autowired
    private GroupStateBoundRepository boundRepo;

    /**
     * Retrieves the GEOJSON for all states.
     * 
     * @return the GeoJson for all states
     */
    @Cacheable("states")
    public List<GeoJson> getAllStates() {
        return geoJsonRepo.findAllStateGeoJsons();
    }

    /**
     * Retrieves the GEOJSON for the state's assembly districts.
     * 
     * @param state the state to retrieve the GeoJson for
     * @return the GeoJson for the specified state
     */
    @Cacheable("assembly-districts")
    public List<GeoJson> getRegularDistrictMapByState(State state) {
        return geoJsonRepo.findDistrictGeoJsonsByState(state);
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
    public List<GeoJson> getHeatMapByStateAndGroup(State state, Group group) {
        return geoJsonRepo.findHeatGeoJsonsByStateAndGroup(state, group);
    }

    /**
     * Retrieves the population bounds for a state and group.
     * 
     * @param state the state to retrieve the bounds for
     * @param group the group to retrieve the bounds for
     * @return the population bounds for the specified state and group
     */
    @Cacheable("legend")
    public GroupStateBound getHeatLegendByStateAndGroup(State state, Group group) {
        return boundRepo.findByStateAndGroup(state, group);
    }

}
