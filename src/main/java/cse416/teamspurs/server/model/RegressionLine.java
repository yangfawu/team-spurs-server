package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.Party;


import lombok.Getter;
import java.util.List;

@Document("gingles-line")
@Getter
public class RegressionLine {
    @Id
    private String id;

    private State state;
    private Group group;
    private Party party;

    private List<Double> coefficients;
}
