package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.model.PrecinctPoint;

@Repository
public interface PrecinctPointRespository extends MongoRepository<PrecinctPoint, String> {
    PrecinctPoint findByStateAndGroup(State state, Group group);

}
