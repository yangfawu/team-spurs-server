package cse416.teamspurs.server.controller;

import java.util.HashMap;

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
import cse416.teamspurs.server.model.District;
import cse416.teamspurs.server.service.DistrictService;
import cse416.teamspurs.server.service.MapService;

@RestController
@RequestMapping("/api/map")
public class MapController {
    @Autowired
    private MapService mapService;

    @Autowired
    private DistrictService districtService;

    @GetMapping(path = "/regular/{state}")
    public ResponseEntity<Object> getReps(
            @PathVariable("state") State state) {
        return new ResponseEntity<>(mapService.getDistrictMap(state), HttpStatus.OK);
    }

    @GetMapping(path = "/heat/{state}/{group}")
    public ResponseEntity<HeatMapDto> getMaxPopFrom(
            @PathVariable("state") State state,
            @PathVariable("group") Group group) {
        var map = mapService.getDistrictMap(state);

        var extreme = districtService.getExtremeByStateAndGroup(state, group);
        var min = extreme.getMin();
        var max = extreme.getMax();

        var districts = districtService.getDistrictsByState(state);
        var table = new HashMap<Integer, District>();
        for (var d : districts) {
            table.put(d.getDistrictId(), d);
        }

        var key = group.getLabel();
        var response = new HeatMapDto(
                min,
                max,
                key,
                table,
                map);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
