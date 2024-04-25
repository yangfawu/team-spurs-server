package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.Box;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;

@Repository
public interface BoxRepository extends MongoRepository<Box, String> {
    Box findByStateAndGroup(State state, Group group);
}
