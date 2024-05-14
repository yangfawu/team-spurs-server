package cse416.teamspurs.server.model; 
import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document; 
import cse416.teamspurs.server.constant.Group; 
import lombok.Getter; 

@Document("") 
@Getter 
public class OpportunityDistrictInfo 
{ 
    @Id private String id; 

    private Group group; 
    private Integer idealPopulation; 
    private Integer actualPopulation; 
    private Integer actualOpportunity; 
    private Integer maxOpportunity; 
    private Integer averageOpportunity; 
}