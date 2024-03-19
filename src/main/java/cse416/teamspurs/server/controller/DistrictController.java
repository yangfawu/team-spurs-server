package cse416.teamspurs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dto.HeatMapDto;
import cse416.teamspurs.server.service.DemographicService;
import cse416.teamspurs.server.service.DistrictService;

@RestController
@RequestMapping("/api/distribution/legend")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @Autowired
    private DemographicService demoService;

    @GetMapping(path = "/{state}/{group}", produces = "application/json")
    public ResponseEntity<HeatMapDto> getMaxPopFrom(
            @PathVariable("state") State state,
            @PathVariable("group") Group group) {
        var min = districtService.getMinPopulationByStateAndGroup(state, group);
        var max = districtService.getMaxPopulationByStateAndGroup(state, group);
        var total = demoService.getDemographicByStateAndGroup(state, group).getPopulation();
        var districts = districtService.getDistrictsByState(state);

        var response = new HeatMapDto(min, max, total, districts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
