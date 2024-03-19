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

    public List<Representative> getAllReps() {
        return repo.findAll();
    }

    public List<Representative> getRepsFrom(String state) {
        return repo.findByState(state);
    }

}
