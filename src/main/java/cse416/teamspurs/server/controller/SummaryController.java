package cse416.teamspurs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.GeoJsonFeature;
import cse416.teamspurs.server.model.OpportunityDistrictDistributionBar;
import cse416.teamspurs.server.model.OpportunityDistrictInfo;
import cse416.teamspurs.server.model.RedistrictingInfo;
import cse416.teamspurs.server.model.Representative;
import cse416.teamspurs.server.model.StateDemographic;
import cse416.teamspurs.server.model.StateVoterDistribution;
import cse416.teamspurs.server.service.SummaryService;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    @Autowired
    private SummaryService service;

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

    @GetMapping("/{state}/voter")
    public ResponseEntity<StateVoterDistribution> getStateVoterDistribution(
            @PathVariable("state") State state) {
        var res = service.getStateVoterDistribution(state);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{state}/opportunity/{threshold}")
    public ResponseEntity<List<OpportunityDistrictInfo>> getOpportunityDistricts(
            @PathVariable("state") State state,
            @PathVariable("threshold") Integer threshold) {
        var res = service.getOpportunityDistrictInfos(state, threshold);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{state}/redistricting")
    public ResponseEntity<RedistrictingInfo> getStateRedistrictingInfo(
            @PathVariable("state") State state) {
        var res = service.getStateRedistrictingInfo(state);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{state}/od-distribution/{group}/{threshold}")
    public ResponseEntity<List<OpportunityDistrictDistributionBar>> getOpportunityDistrictDistribution(
            @PathVariable("state") State state,
            @PathVariable("group") Group group,
            @PathVariable("threshold") String threshold) {
        var res = service.getEnsembleOpportunityDistrictDistribution(state, group, threshold);
        return ResponseEntity.ok(res);
    }

}
