package cse416.teamspurs.server.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.Party;
import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document("gingles-lines")
@Getter
public class RegressionLine {
    @Id
    private String id;

    private State state;
    private Group group;
    private Party party;

    // private LineType type;
    private List<Double> coefficients;
}
