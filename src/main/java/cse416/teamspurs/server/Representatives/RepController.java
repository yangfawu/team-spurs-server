package cse416.teamspurs.server.Representatives;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/reps")
public class RepController {
    @Autowired
    private RepService service;

    @GetMapping()
    public ResponseEntity<List<Reps>> getAllReps() {
        return new ResponseEntity<List<Reps>>(service.getAllReps(), HttpStatus.OK);
    }

    @GetMapping("/{state}")
    public ResponseEntity<List<Reps>> getReps(@PathVariable("state") String state ) {
        return new ResponseEntity<List<Reps>>(service.getRepsFrom(state), HttpStatus.OK);
    }
    
}
