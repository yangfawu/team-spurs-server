package cse416.teamspurs.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.HeatLevel;
import cse416.teamspurs.server.constant.Party;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dto.BoxAndWhiskerDTO;
import cse416.teamspurs.server.dto.HeatMapDTO;
import cse416.teamspurs.server.dto.PrecinctAnalysisDTO;
import cse416.teamspurs.server.model.DistrictDemographic;
import cse416.teamspurs.server.repository.DistrictDemographicRepository;
import cse416.teamspurs.server.repository.EcologicalInferenceLineRepository;
import cse416.teamspurs.server.repository.EnsembleBoxAndWhiskerRepository;
import cse416.teamspurs.server.repository.HeatMapFeatureRepository;
import cse416.teamspurs.server.repository.HeatMapLegendRepository;
import cse416.teamspurs.server.repository.PrecinctPointRespository;
import cse416.teamspurs.server.repository.RegressionLineRespository;
import cse416.teamspurs.server.model.EcologicalInferenceLine;


@Service
public class RacialService {

    @Autowired
    private HeatMapFeatureRepository featureRepo;

    @Autowired
    private HeatMapLegendRepository legendRepo;

    @Autowired
    private PrecinctPointRespository pointRepo;

    @Autowired
    private RegressionLineRespository lineRepo;

    @Autowired
    private DistrictDemographicRepository districtRepo;

    @Autowired
    private EnsembleBoxAndWhiskerRepository boxAndWhiskerRepo;

    @Autowired
    private EcologicalInferenceLineRepository ecoInferenceLineRepo;

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

    @Cacheable("precinct-analysis")
    public PrecinctAnalysisDTO getPrecinctAnalysis(State state, Group group) {
        var rows = pointRepo.findByStateAndGroup(state, group);
        var democratLine = lineRepo.findByStateAndGroupAndParty(state, group, Party.d);
        var republicanLine = lineRepo.findByStateAndGroupAndParty(state, group, Party.r);
        var dto = PrecinctAnalysisDTO.builder()
                .rows(rows)
                .lines(List.of(democratLine, republicanLine))
                .build();
        return dto;
    }

    @Cacheable("box-and-whisker-analysis")
    public BoxAndWhiskerDTO getBoxAndWhiskerAnalysis(State state, Group group) {
        var districts = districtRepo.findByState(state);
        var enacted = new ArrayList<Double>();
        for (DistrictDemographic demo : districts) {
            var value = demo.getCount().getOrDefault(group, 0);
            var total = demo.getCount().values().stream().reduce(0, Integer::sum);
            var percent = total == 0 ? 0.0 : ((double) value) / total;
            enacted.add(percent);
        }
        enacted.sort(null);

        var boxes = boxAndWhiskerRepo.findByStateAndGroup(state, group);

        var dto = BoxAndWhiskerDTO.builder()
                .enacted(enacted)
                .boxes(boxes)
                .build();
        return dto;
    }

    @Cacheable("eco-lines")
    public List<EcologicalInferenceLine> getEcoInferenceLines(State state){
        return ecoInferenceLineRepo.findByState(state);
    }

}
