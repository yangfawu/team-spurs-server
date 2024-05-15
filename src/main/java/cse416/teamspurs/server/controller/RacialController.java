package cse416.teamspurs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.HeatLevel;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dto.BoxAndWhiskerDTO;
import cse416.teamspurs.server.dto.HeatMapDTO;
import cse416.teamspurs.server.dto.PrecinctAnalysisDTO;
import cse416.teamspurs.server.service.RacialService;
import cse416.teamspurs.server.model.EcologicalInferenceLine;

import java.util.List;

@RestController
@RequestMapping("/api/racial")
public class RacialController {

    @Autowired
    private RacialService service;

    @GetMapping("/heat/{state}/{level}/{group}")
    public ResponseEntity<HeatMapDTO> getHeapMap(
            @PathVariable("state") State state,
            @PathVariable("level") HeatLevel level,
            @PathVariable("group") Group group) {
        var res = service.getHeatMap(state, level, group);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/precinct/{state}/{group}")
    public ResponseEntity<PrecinctAnalysisDTO> getPrecinctAnalysis(
            @PathVariable("state") State state,
            @PathVariable("group") Group group) {
        var res = service.getPrecinctAnalysis(state, group);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/box/{state}/{group}")
    public ResponseEntity<BoxAndWhiskerDTO> getBoxAndWhiskerAnalysis(
            @PathVariable("state") State state,
            @PathVariable("group") Group group) {
        var res = service.getBoxAndWhiskerAnalysis(state, group);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/ei/{state}")
    public ResponseEntity<List<EcologicalInferenceLine>> getEcologicalInferenceLine(
        @PathVariable("state") State state)
    {
        var res = service.getEcoInferenceLines(state);
        return ResponseEntity.ok(res); 
    }

}
