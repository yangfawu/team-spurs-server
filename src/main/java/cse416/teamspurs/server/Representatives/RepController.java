package cse416.teamspurs.server.Representatives;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/rep")
public class RepController {
    @Autowired
    private VirginaRepService virginaRepService;

    @GetMapping()
    public ResponseEntity<List<VirginaReps>> getAllVirginaReps() {
        return new ResponseEntity<List<VirginaReps>>(virginaRepService.getAllVirginaReps(), HttpStatus.OK);
    }
    
}