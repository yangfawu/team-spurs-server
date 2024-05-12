package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.EnsembleBoxAndWhisker;

@Repository
public interface EnsembleBoxAndWhiskerRepository extends MongoRepository<EnsembleBoxAndWhisker, String> {

    @Query(sort = "{min: 1}")
    public List<EnsembleBoxAndWhisker> findByStateAndGroup(State state, Group group);

}
