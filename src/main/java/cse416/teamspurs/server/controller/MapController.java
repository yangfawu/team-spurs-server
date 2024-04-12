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
import cse416.teamspurs.server.model.GeoJson;
import cse416.teamspurs.server.service.MapService;

@RestController
@RequestMapping("/api/map")
public class MapController {

    @Autowired
    private MapService service;

    @GetMapping("/states")
    public ResponseEntity<List<GeoJson>> getAllStates() {
        var res = service.getAllStates();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/regular/{state}")
    public ResponseEntity<List<GeoJson>> getStateMap(
            @PathVariable("state") State state) {
        var res = service.getRegularDistrictMapByState(state);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/heat/{state}/{group}")
    public ResponseEntity<List<GeoJson>> getHeatMap(
            @PathVariable("state") State state,
            @PathVariable("group") Group group) {
        var res = service.getHeatMapByStateAndGroup(state, group);
        return ResponseEntity.ok(res);
    }

}
