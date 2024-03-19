package cse416.teamspurs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.converter.StringToStateConverter;
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

    @Autowired
    private StringToStateConverter stateConverter;

    // @GetMapping()
    // public ResponseEntity <List<District>> getAllDistricts()
    // {
    // return new ResponseEntity<List<District>>(service.getAllDistrict(),
    // HttpStatus.OK);
    // }

    @GetMapping(path = "/{state}/{group}", produces = "application/json")
    public ResponseEntity<HeatMapDto> getMaxPopFrom(
            @PathVariable("state") State state,
            @PathVariable("group") String group) {
        HeatMapDto response = new HeatMapDto();
        response.setMin(districtService.getMinPopFrom(state, group));
        response.setmax(districtService.getMaxPopFrom(state, group));
        response.setTotal(demoService.getGroupDemoFrom(state, group));
        response.setDistricts(districtService.getDistrictsFrom(state));

        return new ResponseEntity<HeatMapDto>(response, HttpStatus.OK);
    }

}
