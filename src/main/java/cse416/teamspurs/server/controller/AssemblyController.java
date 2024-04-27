package cse416.teamspurs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.GeoJsonFeature;
import cse416.teamspurs.server.model.Representative;
import cse416.teamspurs.server.model.StateDemographic;
import cse416.teamspurs.server.service.AssemblyService;

@RestController
@RequestMapping("/api/assembly")
public class AssemblyController {

    @Autowired
    private AssemblyService service;

    @GetMapping("/{state}/demographic")
    public ResponseEntity<StateDemographic> getStateDemographic(
            @PathVariable("state") State state) {
        var res = service.getStateDemographic(state);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{state}/plan")
    public ResponseEntity<List<GeoJsonFeature>> getStateAssemblyPlan(
            @PathVariable("state") State state) {
        var res = service.getAssemblyPlanByState(state);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{state}/representatives")
    public ResponseEntity<List<Representative>> getStateRepresentatives(
            @PathVariable("state") State state) {
        var res = service.getRepresentativesByState(state);
        return ResponseEntity.ok(res);
    }

}