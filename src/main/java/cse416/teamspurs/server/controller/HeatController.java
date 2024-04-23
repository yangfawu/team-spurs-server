package cse416.teamspurs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.HeatLevel;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dto.HeatMapDTO;
import cse416.teamspurs.server.service.HeatService;

@RestController
@RequestMapping("/api/heat")
public class HeatController {

    @Autowired
    private HeatService service;

    @GetMapping("/{state}/{level}/{group}")
    public ResponseEntity<HeatMapDTO> getHeapMap(
            @PathVariable("state") State state,
            @PathVariable("level") HeatLevel level,
            @PathVariable("group") Group group) {
        var res = service.getHeatMap(state, level, group);
        return ResponseEntity.ok(res);
    }

}
