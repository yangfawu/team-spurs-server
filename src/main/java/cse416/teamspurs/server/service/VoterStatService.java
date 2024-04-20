package cse416.teamspurs.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.VoterStat;
import cse416.teamspurs.server.repository.VoterStatRepository;

@Service
public class VoterStatService {

    @Autowired
    private VoterStatRepository repo;

    /**
     * Get voter statistics by state
     * 
     * @param state the state to get the voter statistics for
     * @return the voter statistics for the specified state
     */
    @Cacheable("voters")
    public VoterStat getVoterStatByState(State state) {
        return repo.findByState(state);
    }

}
