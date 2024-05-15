package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "redistricting-info")
@Getter
public class RedistrictingInfo {
    @Id
    private String id;

    private State state;

    private String name;
    private String website;
    private String comments;
}
