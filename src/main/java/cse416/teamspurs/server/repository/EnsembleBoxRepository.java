package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.EnsembleBox;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import java.util.List;

@Repository
public interface EnsembleBoxRepository extends MongoRepository<EnsembleBox, String> {
    List<EnsembleBox> findByStateAndGroup(State state, Group group);
}
