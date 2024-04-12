package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.GroupStateBound;

@Repository
public interface GroupStateBoundRepository extends MongoRepository<GroupStateBound, String> {

    public GroupStateBound findByStateAndGroup(State state, Group group);

}
