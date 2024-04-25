package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.Group;

import lombok.Getter;

@Document("seawulf-boxes")
@Getter
public class Box {
    @Id
    private String id;

    private State state;
    private Group group;

    private Integer district;    
    private Integer actual;

    private Integer max;
    private Integer median;
    private Integer min;
    private Integer q1;
    private Integer q3;

}
