package cse416.teamspurs.server.Voter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
