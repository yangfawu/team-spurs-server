package cse416.teamspurs.server.District;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
//import java.util.List;

@RestController
@RequestMapping("/api/distribution/legend")
public class DistrictController {
    @Autowired
    private DistrictService service;

    // @GetMapping()
    // public ResponseEntity <List<District>> getAllDistricts()
    // {
    //     return new ResponseEntity<List<District>>(service.getAllDistrict(), HttpStatus.OK);
    // }

    @GetMapping("/{state}/{group}/max")
    public ResponseEntity <Integer> getMaxPopFrom(@PathVariable("state") String state, @PathVariable("group") String group)
    {
        return new ResponseEntity<Integer>(service.getMaxPopFrom(state, group), HttpStatus.OK);
    } 
    
}