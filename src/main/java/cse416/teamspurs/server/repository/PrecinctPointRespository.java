package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.PrecinctPoint;

@Repository
public interface PrecinctPointRespository extends MongoRepository<PrecinctPoint, String> {

    List<PrecinctPoint> findByStateAndGroup(State state, Group group);

}
