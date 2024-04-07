package cse416.teamspurs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.DistrictDemographic;
import cse416.teamspurs.server.model.StateDemographic;
import cse416.teamspurs.server.service.DemographicService;

@RestController
@RequestMapping("/api/demo")
public class DemographicController {

    @Autowired
    private DemographicService service;

    @GetMapping("/overall/{state}")
    public ResponseEntity<StateDemographic> getOverallDemographicsByState(
            @PathVariable("state") State state) {
        var optionalDemo = service.getStateDemographic(state);

        // this check is necessary because the return type is Optional
        // this check will probably never execute because the state input is an enum
        if (optionalDemo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var demo = optionalDemo.get();
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }

    @GetMapping(path = "/district/{state}")
    public ResponseEntity<List<DistrictDemographic>> getDistrictDemographicsByState(
            @PathVariable("state") State state) {
        var res = service.getDistrictDemographicsByState(state);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
