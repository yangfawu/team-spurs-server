package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "state-demographic")
@Getter
public class StateDemographic {
    @Id
    private String id;

    private Map<Group, Integer> count;
    private State state;
}
