package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.Party;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.RegressionLine;

@Repository
public interface RegressionLineRespository extends MongoRepository<RegressionLine, String> {

    RegressionLine findByStateAndGroupAndParty(State state, Group group, Party party);

}
