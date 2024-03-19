package cse416.teamspurs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.model.Representative;
import cse416.teamspurs.server.service.RepresentativeService;

@RestController
@RequestMapping("/api/reps")
public class RepresentativeController {
    @Autowired
    private RepresentativeService service;

    @GetMapping()
    public ResponseEntity<List<Representative>> getAllReps() {
        return new ResponseEntity<List<Representative>>(service.getAllReps(), HttpStatus.OK);
    }

    @GetMapping("/{state}")
    public ResponseEntity<List<Representative>> getReps(@PathVariable("state") String state) {
        return new ResponseEntity<List<Representative>>(service.getRepsFrom(state), HttpStatus.OK);
    }

}
