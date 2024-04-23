package cse416.teamspurs.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.HeatLevel;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.HeatMapLegend;

@Repository
public interface HeatMapLegendRepository extends MongoRepository<HeatMapLegend, String> {

    public HeatMapLegend findByStateAndLevelAndGroup(State state, HeatLevel level, Group group);

}
