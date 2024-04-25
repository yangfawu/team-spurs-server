package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.Group;

import lombok.Getter;

@Document("seawulf-boxes")
@Getter
public class EnsembleBox {
    @Id
    private String id;

    private State state;
    private Group group;

    private Integer district;    
    private Double actual;

    private Double max;
    private Double median;
    private Double min;
    private Double q1;
    private Double q3;

}
