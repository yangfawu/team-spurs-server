package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.RedistrictingInfo;

@Repository
public interface RedistrictingInfoRepository extends MongoRepository<RedistrictingInfo, String> {

    public RedistrictingInfo findByState(State state);

}
