package cse416.teamspurs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.VoterStat;
import cse416.teamspurs.server.service.VoterStatService;

@RestController
@RequestMapping("/api/voter")
public class VoterStatController {

    @Autowired
    private VoterStatService service;

    @GetMapping("/{state}")
    public ResponseEntity<VoterStat> getStatByState(@PathVariable("state") State state) {
        var res = service.getVoterStatByState(state);
        return ResponseEntity.ok(res);
    }

}
