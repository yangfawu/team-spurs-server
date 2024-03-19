package cse416.teamspurs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.model.Demographic;
import cse416.teamspurs.server.service.DemographicService;

@RestController
@RequestMapping("/api/distribution")
public class DemographicController {
    @Autowired
    private DemographicService service;

    @GetMapping("/pop/{state}")
    public ResponseEntity<List<Demographic>> getDemoFrom(@PathVariable("state") String state) {
        return new ResponseEntity<List<Demographic>>(service.getDemoFrom(state), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Demographic>> getAllDemographics() {
        return new ResponseEntity<List<Demographic>>(service.getAllDemographics(), HttpStatus.OK);
    }

}
