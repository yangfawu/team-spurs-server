package cse416.teamspurs.server.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.Party;

import lombok.Getter;

@Document("ei-lines")
@Getter
public class EcologicalInferenceLine 
{
    @Id
    private String id;

    private Group group;
    private Party party;
    private State state;

    private Integer min;
    private Integer max;

    private Map<Integer, Double> values;


}
