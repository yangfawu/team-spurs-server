package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dao.NJGeoJsonDao;
import cse416.teamspurs.server.dao.VAGeoJsonDao;

@Service
public class MapService {

    @Autowired
    private VAGeoJsonDao vaRepo;

    @Autowired
    private NJGeoJsonDao njRepo;

    /**
     * Retrieves the district maps in a specific state.
     * 
     * @param state the state to retrieve the district maps from
     * @return a list of district maps in the specified state
     */
    private List<?> getDistrictMaps(State state) {
        switch (state) {
            case NJ:
                return njRepo.findAll();
            case VA:
                return vaRepo.findAll();
            default:
                throw new IllegalStateException();
        }
    }

    /**
     * Retrieves the district map in a specific state.
     * 
     * @param state the state to retrieve the district map from
     * @return the district map in the specified state
     */
    public Object getDistrictMap(State state) {
        var maps = getDistrictMaps(state);
        return maps.get(0);
    }

}
