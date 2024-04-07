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
import cse416.teamspurs.server.dto.HeatMapDTO;
import cse416.teamspurs.server.model.GeoJson;
import cse416.teamspurs.server.service.MapService;

@RestController
@RequestMapping("/api/map")
public class MapController {

    @Autowired
    private MapService service;

    @GetMapping(path = "/regular/{state}")
    public ResponseEntity<List<GeoJson>> getReps(
            @PathVariable("state") State state) {
        var res = service.getAssemblyDistrictsByState(state);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(path = "/heat/{state}/{group}")
    public ResponseEntity<HeatMapDTO> getMaxPopFrom(
            @PathVariable("state") State state,
            @PathVariable("group") Group group) {
        var res = service.getHeatedAssymblyDistrictsByStateAndGroup(state, group);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
