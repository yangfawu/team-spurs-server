package cse416.teamspurs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.model.GeoJsonFeature;
import cse416.teamspurs.server.service.MiscService;

@RestController
@RequestMapping("/api/misc")
public class MiscController {

    @Autowired
    private MiscService service;

    @GetMapping("/states")
    public ResponseEntity<List<GeoJsonFeature>> getAllStates() {
        var res = service.getAllStates();
        return ResponseEntity.ok(res);
    }

}
