package cse416.teamspurs.server.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "seawulf-plans")
@Getter
public class SeawulfPlan {
    @Id
    private String id;

    private State state;
    private Integer plan;
    private List<String> comments;
}
