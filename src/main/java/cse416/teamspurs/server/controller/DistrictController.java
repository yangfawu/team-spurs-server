package cse416.teamspurs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse416.teamspurs.server.dto.HeatMapDTO;
import cse416.teamspurs.server.service.DemographicService;
import cse416.teamspurs.server.service.DistrictService;

@RestController
@RequestMapping("/api/distribution/legend")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @Autowired
    private DemographicService demoService;

    // @GetMapping()
    // public ResponseEntity <List<District>> getAllDistricts()
    // {
    // return new ResponseEntity<List<District>>(service.getAllDistrict(),
    // HttpStatus.OK);
    // }

    @GetMapping(path = "/{state}/{group}", produces = "application/json")
    public ResponseEntity<HeatMapDTO> getMaxPopFrom(@PathVariable("state") String state,
            @PathVariable("group") String group) {
        switch (state) {
            case "nj":
                state = "New Jersey";
                break;
            case "va":
                state = "Virginia";
                break;
            default:
                state = "New Jersey";
                break;
        }

        HeatMapDTO response = new HeatMapDTO();
        response.setMin(districtService.getMinPopFrom(state, group));
        response.setmax(districtService.getMaxPopFrom(state, group));
        response.setTotal(demoService.getGroupDemoFrom(state, group));
        response.setDistricts(districtService.getDistrictsFrom(state));

        return new ResponseEntity<HeatMapDTO>(response, HttpStatus.OK);
    }

}
