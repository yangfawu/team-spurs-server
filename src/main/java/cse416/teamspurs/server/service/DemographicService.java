package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.dao.DemographicDao;
import cse416.teamspurs.server.model.Demographic;

@Service
public class DemographicService {
    @Autowired
    private DemographicDao repo;

    public List<Demographic> getAllDemographics() {
        return repo.findAll();
    }

    public List<Demographic> getLabelInfo(String label) {
        return repo.findByLabel(label);
    }

    public List<Demographic> getDemoFrom(String state) {
        return repo.findByState(state);
    }

    public Integer getGroupDemoFrom(State state, String group) {
        var mongoState = state.getLabel();
        return repo.findByStateAndLabel(mongoState, group).getPopulation();
    }

}
