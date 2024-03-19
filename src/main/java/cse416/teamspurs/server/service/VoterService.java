package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.dao.VoterDao;
import cse416.teamspurs.server.model.Voter;

@Service
public class VoterService {

    @Autowired
    private VoterDao repo;

    /**
     * Retrieves all voters.
     * 
     * @return a list of voters
     */
    public List<Voter> getAllVoters() {
        return repo.findAll();
    }

    /**
     * Retrieves all voters by state.
     * 
     * @param state the state to retrieve voters from
     * @return a list of voters
     */
    public List<Voter> votersFromState(String state) {
        return repo.findByState(state);
    }

    /**
     * Retrieves all voters by party.
     * 
     * @param party the party to retrieve voters from
     * @return a list of voters in the specified party
     */
    public List<Voter> votersForParty(String party) {
        return repo.findByParty(party);
    }

}
