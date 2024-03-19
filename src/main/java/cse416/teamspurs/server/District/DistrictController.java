package cse416.teamspurs.server.District;

import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.MapResponse;
import cse416.teamspurs.server.Demographics.DemographicsService;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import java.util.List;

@RestController
@RequestMapping("/api/distribution/legend")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @Autowired
    private DemographicsService demoService;

    // @GetMapping()
    // public ResponseEntity <List<District>> getAllDistricts()
    // {
    //     return new ResponseEntity<List<District>>(service.getAllDistrict(), HttpStatus.OK);
    // }

    @GetMapping(path = "/{state}/{group}", produces = "application/json")
    public ResponseEntity <MapResponse> getMaxPopFrom(@PathVariable("state") String state, @PathVariable("group") String group)
    {
        MapResponse response = new MapResponse();
        response.setMin(districtService.getMinPopFrom(state, group));
        response.setmax(districtService.getMaxPopFrom(state, group));
        response.setTotal(demoService.getGroupDemoFrom(state, "White"));


        return new ResponseEntity<MapResponse>(response, HttpStatus.OK);
    } 
    
}
