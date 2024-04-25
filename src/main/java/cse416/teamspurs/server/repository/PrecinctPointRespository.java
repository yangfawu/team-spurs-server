package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.model.PrecinctPoint;

import java.util.List;

@Repository
public interface PrecinctPointRespository extends MongoRepository<PrecinctPoint, String> {
    List<PrecinctPoint> findByStateAndGroup(State state, Group group);

}
