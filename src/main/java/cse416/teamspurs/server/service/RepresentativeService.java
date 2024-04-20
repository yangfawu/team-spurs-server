package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.Representative;
import cse416.teamspurs.server.repository.RepresentativeRepository;

@Service
public class RepresentativeService {

    @Autowired
    private RepresentativeRepository repo;

    /**
     * Retrieves all representatives by party.
     * 
     * @param party the party to retrieve representatives from
     * @return a list of representatives in the specified party
     */
    @Cacheable("reps")
    public List<Representative> getAllByState(State state) {
        return repo.findByState(state);
    }

}
