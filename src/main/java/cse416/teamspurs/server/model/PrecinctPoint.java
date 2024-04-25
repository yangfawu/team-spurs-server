package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.Group;

import lombok.Getter;

@Document("gingles-points")
@Getter
public class PrecinctPoint {
    @Id
    private String id;

    private State state;
    private Group group;
    private String name;

    private Integer total_population;
    private Integer group_population;

    private Double percent_group;
    private Double percent_democrat;
    private Double percent_republican;

}
