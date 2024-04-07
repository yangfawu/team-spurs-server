package cse416.teamspurs.server.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dto.HeatMapDTO;
import cse416.teamspurs.server.model.DistrictDemographic;
import cse416.teamspurs.server.model.GeoJson;
import cse416.teamspurs.server.repository.GeoJsonRepository;

@Service
public class MapService {

    private final String HEAT_PROPERTY_KEY = "heat_value";

    @Autowired
    private GeoJsonRepository geoJsonRepo;

    @Autowired
    private DemographicService demoService;

    /**
     * Retrieves the GEOJSON for the state's assembly districts.
     * 
     * @param state the state to retrieve the GeoJson for
     * @return the GeoJson for the specified state
     */
    @Cacheable("assembly-districts")
    public List<GeoJson> getAssemblyDistrictsByState(State state) {
        return geoJsonRepo.findByState(state);
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
    public HeatMapDTO getHeatedAssemblyDistrictsByStateAndGroup(State state, Group group) {
        var bounds = demoService.getPopulationBoundsByStateAndGroup(state, group);
        var min = bounds.getMin();
        var max = bounds.getMax();
        var diff = (double) max - min;

        // Get the demographic data for each district and store it in a map
        var districDemos = demoService.getDistrictDemographicsByState(state);
        var districtToDemo = new HashMap<Integer, DistrictDemographic>();
        for (var demo : districDemos) {
            districtToDemo.put(demo.getDistrict(), demo);
        }

        // Get the district GeoJson for the state
        // We will add a property to each feature with the heat value
        var features = geoJsonRepo.findByState(state);

        if (min >= max) {
            // Heat value is impossible to calculate through nornmal means
            // Thus, we assume 0 for all districts
            for (var feature : features) {
                feature.getProperties().put(HEAT_PROPERTY_KEY, 0.0);
            }
        } else {
            for (var feature : features) {
                var rawDistrict = feature.getProperties().get("district");

                // If the district is not an integer, set the heat value to 0
                if (!(rawDistrict instanceof Integer)) {
                    feature.getProperties().put(HEAT_PROPERTY_KEY, 0.0);
                    continue;
                }

                var district = (Integer) rawDistrict;

                // Use district to get the demographic data for the district
                var demo = districtToDemo.get(district);
                var count = demo.getCount().getOrDefault(group, 0);

                // Calculate the heat value and store it in properties
                double heat_value = Math.max(0, (count - min)) / diff;
                feature.getProperties().put(HEAT_PROPERTY_KEY, heat_value);
            }
        }

        var dto = new HeatMapDTO(min, max, features);
        return dto;
    }

}
