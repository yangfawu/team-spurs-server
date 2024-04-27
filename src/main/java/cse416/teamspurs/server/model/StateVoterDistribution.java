package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Party;
import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "state-voters")
@Getter
public class StateVoterDistribution {
    @Id
    private String id;

    private State state;
    private Map<Party, Integer> breakdown;
}
