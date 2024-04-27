package cse416.teamspurs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dto.PrecinctAnalysisDTO;
import cse416.teamspurs.server.service.PrecinctService;

@Controller
@RequestMapping("/api/precinct")
public class PrecinctController {

    @Autowired
    private PrecinctService service;

    @GetMapping("/{state}/{group}")
    public ResponseEntity<PrecinctAnalysisDTO> getPrecinctAnalysis(
            @PathVariable("state") State state,
            @PathVariable("group") Group group) {
        var res = service.getPrecinctAnalysis(state, group);
        return ResponseEntity.ok(res);
    }

}
