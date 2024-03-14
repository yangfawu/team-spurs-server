package cse416.teamspurs.server.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/map")
public class MapController {
    @GetMapping()
    public String getMethodName() {
        return "Testing this out";
    }
    
}
