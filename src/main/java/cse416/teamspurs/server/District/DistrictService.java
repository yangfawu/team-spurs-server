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
}
