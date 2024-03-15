package cse416.teamspurs.server.Demographics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("/api/distribution")  
public class DemographicsController {
    @Autowired
    private DemographicsService service;

    @GetMapping("/pop/{state}")
    public ResponseEntity <List <Demographics>> getDemoFrom(@PathVariable("state") String state)
    {
        return new ResponseEntity< List<Demographics>>(service.getDemoFrom(state), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity< List<Demographics> > getAllDemographics()
    {
        return new ResponseEntity< List<Demographics>>(service.getAllDemographics(), HttpStatus.OK);
    }
    
}
