package cse416.teamspurs.server.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.Party;
import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "legislators")
@Getter
public class Representative {
    @Id
    private String id;

    private String first_name;
    private String last_name;
    private Integer district;
    private Party party;
    private List<Group> race;
    private String image;
    private State state;
}
