package cse416.teamspurs.server.model; 
import java.util.List;

import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document; 
import cse416.teamspurs.server.constant.Group; 
import cse416.teamspurs.server.constant.State; 
import lombok.Getter; 

@Document("opportunity-districts") 
@Getter 
public class OpportunityDistrictInfo 
{ 
    @Id 
    private String id; 

    private State state;
    private Group group;

    private Integer threshold;
    private Integer ideal_population;
    private Integer actual_population;
    private Integer max_opp_districts;

    private List<Integer> actual_opp_districts;

    private Integer avg_opp_districts;
    
    
}