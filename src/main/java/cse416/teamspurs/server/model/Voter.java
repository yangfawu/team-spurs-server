package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "voter-statistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voter {
    @Id
    private String Id;

    private String party;
    private Integer value;
    private Double percent_of_VAP;
    private State state;
}
