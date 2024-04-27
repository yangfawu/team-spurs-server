package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.Party;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dto.PrecinctAnalysisDTO;
import cse416.teamspurs.server.repository.PrecinctPointRespository;
import cse416.teamspurs.server.repository.RegressionLineRespository;

@Service
public class PrecinctService {

    @Autowired
    private PrecinctPointRespository pointRepo;

    @Autowired
    private RegressionLineRespository lineRepo;

    @Cacheable("precinct-analysis")
    public PrecinctAnalysisDTO getPrecinctAnalysis(State state, Group group) {
        var rows = pointRepo.findByStateAndGroup(state, group);
        var democratLine = lineRepo.findByStateAndGroupAndParty(state, group, Party.d);
        var republicanLine = lineRepo.findByStateAndGroupAndParty(state, group, Party.r);
        var dto = PrecinctAnalysisDTO.builder()
                .rows(rows)
                .lines(List.of(democratLine, republicanLine))
                .build();
        return dto;
    }

}
