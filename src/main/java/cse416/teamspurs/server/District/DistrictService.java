package cse416.teamspurs.server.District;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repo;

    public List<District> getAllDistrict()
    {
        return repo.findAll();
    }

    public List<District> getDistrictsFrom(String state)
    {
        return repo.findByState(state);
    }

    public Integer getMaxPop(String state, String label)
    {
        return getDistrictsFrom(state).max();
        
        //findFirstByOrderBySeatNumberAsc();
    }
}
