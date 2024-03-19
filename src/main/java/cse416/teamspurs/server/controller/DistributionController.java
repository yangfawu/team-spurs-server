package cse416.teamspurs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.Demographic;
import cse416.teamspurs.server.model.District;
import cse416.teamspurs.server.service.DemographicService;
import cse416.teamspurs.server.service.DistrictService;

@RestController
@RequestMapping("/api/distribution")
public class DistributionController {
    @Autowired
    private DemographicService demoService;

    @Autowired
    private DistrictService districtService;

    @GetMapping("/overall/{state}")
    public ResponseEntity<List<Demographic>> getOverallDemographicsByState(
            @PathVariable("state") State state) {
        var arr = demoService.getDemographicsByState(state);
        return new ResponseEntity<>(arr, HttpStatus.OK);
    }

    @GetMapping(path = "/overall/{state}/{group}")
    public ResponseEntity<Demographic> getOverallGroupDemographicsByState(
            @PathVariable("state") State state,
            @PathVariable("group") Group group) {
        var demo = demoService.getDemographicByStateAndGroup(state, group);
        return new ResponseEntity<>(demo, HttpStatus.OK);
    }

    @GetMapping(path = "/district/{state}")
    public ResponseEntity<List<District>> getDistrictDemographicsByState(
            @PathVariable("state") State state) {
        var districts = districtService.getDistrictsByState(state);
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }

}
