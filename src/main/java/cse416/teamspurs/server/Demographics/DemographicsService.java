package cse416.teamspurs.server.Demographics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemographicsService {
    @Autowired
    private DemographicsRespository repo;

    public List<Demographics> getAllDemographics()
    {
        return repo.findAll();
    }

    public List<Demographics> getLabelInfo(String label)
    {
        return repo.findByLabel(label);
    }

    public List<Demographics> getDemoFrom(String state)
    {
        return repo.findByState(state);
    }

    public Integer getGroupDemoFrom(String state, String group)
    {
        return repo.findByStateAndLabel(state, group).getPopulation();
    }

}
