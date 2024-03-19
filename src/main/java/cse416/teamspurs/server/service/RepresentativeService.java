package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.dao.RepresentativeDao;
import cse416.teamspurs.server.model.Representative;

@Service
public class RepresentativeService {

    @Autowired
    private RepresentativeDao repo;

    /**
     * Retrieves all representatives.
     * 
     * @return a list of representatives
     */
    public List<Representative> getAll() {
        return repo.findAll();
    }

    /**
     * Retrieves all representatives by party.
     * 
     * @param party the party to retrieve representatives from
     * @return a list of representatives in the specified party
     */
    public List<Representative> getAllByState(String state) {
        return repo.findByState(state);
    }

}
