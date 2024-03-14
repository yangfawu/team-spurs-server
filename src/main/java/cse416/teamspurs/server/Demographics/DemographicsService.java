package cse416.teamspurs.server.Demographics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemographicsService {
    @Autowired
    private DemographicsRespository respository;

    public List<Demographics> getAllDemographics()
    {
        return respository.findAll();
    }

}
