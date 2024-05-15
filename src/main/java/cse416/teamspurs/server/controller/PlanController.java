package cse416.teamspurs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.SeawulfFeature;
import cse416.teamspurs.server.model.SeawulfPlan;
import cse416.teamspurs.server.service.PlanService;

@RestController
@RequestMapping("/api/plan")
public class PlanController {

    @Autowired
    private PlanService service;

    @GetMapping("/{state}/options")
    public ResponseEntity<List<SeawulfPlan>> getStateEnsembleOptions(
            @PathVariable("state") State state) {
        var res = service.getStateEnsemblePlanOptions(state);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{state}/features/{plan}")
    public ResponseEntity<List<SeawulfFeature>> getStatEnsemble(
            @PathVariable("state") State state,
            @PathVariable("plan") Integer plan) {
        var res = service.getStateEnsemblePlan(state, plan);
        return ResponseEntity.ok(res);
    }

}
