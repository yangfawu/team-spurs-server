package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import lombok.Data;

@Document(collection = "pop-bounds")
@Data
public class GroupStateBound {
    @Id
    private String id;

    private State state;
    private Group group;
    private Integer min;
    private Integer max;
}
