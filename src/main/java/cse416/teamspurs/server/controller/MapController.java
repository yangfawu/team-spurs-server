package cse416.teamspurs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.service.MapService;

@RestController
@RequestMapping("/api/map")
public class MapController {

    @Autowired
    private MapService service;

    @GetMapping("/districts/{state}")
    public ResponseEntity<Object> getReps(@PathVariable("state") State state) {
        return new ResponseEntity<>(service.getDistrictMap(state), HttpStatus.OK);
    }

}
