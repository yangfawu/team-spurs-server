package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.Representative;

@Repository
public interface RepresentativeRepository extends MongoRepository<Representative, String> {

    public List<Representative> findByState(State state);

}
