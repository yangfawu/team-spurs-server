package cse416.teamspurs.server.Representatives;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepService {
    @Autowired
    private RepRepository repo;

    public List<Reps> getAllReps() {
        return repo.findAll();
    }

    public List<Reps> getRepsFrom(String state) {
        return repo.findByState(state);
    }

}
