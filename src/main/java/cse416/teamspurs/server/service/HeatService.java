package cse416.teamspurs.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.HeatLevel;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dto.HeatMapDTO;
import cse416.teamspurs.server.repository.HeatMapFeatureRepository;
import cse416.teamspurs.server.repository.HeatMapLegendRepository;

@Service
public class HeatService {

    @Autowired
    private HeatMapFeatureRepository featureRepo;

    @Autowired
    private HeatMapLegendRepository legendRepo;

    @Cacheable("heat-map")
    public HeatMapDTO getHeatMap(State state, HeatLevel level, Group group) {
        var legend = legendRepo.findByStateAndLevelAndGroup(state, level, group);
        var features = featureRepo.findByStateAndLevel(state, level);
        var dto = HeatMapDTO.builder()
                .features(features)
                .legend(legend)
                .build();
        return dto;
    }

}
