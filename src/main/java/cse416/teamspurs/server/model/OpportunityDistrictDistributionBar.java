package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "od-bars")
@Getter
public class OpportunityDistrictDistributionBar {
    @Id
    private String id;

    private State state;
    private Group group;
    private String threshold;

    private Integer districts;
    private Integer plans;
}
