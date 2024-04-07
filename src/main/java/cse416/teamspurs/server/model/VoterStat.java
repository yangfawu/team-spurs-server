package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Party;
import cse416.teamspurs.server.constant.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "voter-statistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoterStat {
    @Id
    private String id;

    private Map<Party, Integer> count;
    private Integer VAP;
    private State state;
}