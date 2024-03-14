package cse416.teamspurs.server.Demographics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController
@RequestMapping("/api/v1/demo")  
public class DemographicsController {
    @Autowired
    private DemographicsService service;

    @GetMapping()
    public ResponseEntity< List<Demographics> > getAllDemographics()
    {
        return new ResponseEntity< List<Demographics>>(service.getAllDemographics(), HttpStatus.OK);
    }
    
}
