package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.dao.VoterRepository;
import cse416.teamspurs.server.model.Voter;

@Service
public class VoterService {
    @Autowired
    private VoterRepository repo;

    public List<Voter> getAllVoters() {
        return repo.findAll();
    }

    public List<Voter> votersFromState(String state) {
        return repo.findByState(state);
    }

    public List<Voter> votersForParty(String party) {
        return repo.findByParty(party);
    }

}
