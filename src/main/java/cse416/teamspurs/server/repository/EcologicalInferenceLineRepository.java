package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cse416.teamspurs.server.model.EcologicalInferenceLine;
import cse416.teamspurs.server.constant.State;

import java.util.List;

public interface EcologicalInferenceLineRepository extends MongoRepository<EcologicalInferenceLine, String>{
    public List<EcologicalInferenceLine> findByState(State state);
}
