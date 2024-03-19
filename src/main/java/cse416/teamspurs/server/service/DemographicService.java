package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.dao.DemographicRespository;
import cse416.teamspurs.server.model.Demographic;

@Service
public class DemographicService {
    @Autowired
    private DemographicRespository repo;

    public List<Demographic> getAllDemographics() {
        return repo.findAll();
    }

    public List<Demographic> getLabelInfo(String label) {
        return repo.findByLabel(label);
    }

    public List<Demographic> getDemoFrom(String state) {
        return repo.findByState(state);
    }

    public Integer getGroupDemoFrom(String state, String group) {
        return repo.findByStateAndLabel(state, group).getPopulation();
    }

}
