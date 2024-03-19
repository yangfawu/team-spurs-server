package cse416.teamspurs.server.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "legislators")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voter {
    @Id
    private ObjectId Id;

    private String party;

    private Integer value;

    private Double percent_of_VAP;

    private String state;

}
