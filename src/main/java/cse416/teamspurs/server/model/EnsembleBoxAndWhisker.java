package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document("seawulf-boxes")
@Getter
public class EnsembleBoxAndWhisker {
    @Id
    private String id;

    private State state;
    private Group group;
    
    private Integer district;

    private Double min;
    private Double q1;
    private Double med;
    private Double q3;
    private Double max;
}
