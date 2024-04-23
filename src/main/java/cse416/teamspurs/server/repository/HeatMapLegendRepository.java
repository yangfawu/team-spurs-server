package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.model.HeatMapLegend;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.HeatLevel;

@Repository
public interface HeatMapLegendRepository extends MongoRepository<HeatMapLegend, String>{
    public HeatMapLegend findByStateAndGroupAndLevel(State state, Group group, HeatLevel level);
}
