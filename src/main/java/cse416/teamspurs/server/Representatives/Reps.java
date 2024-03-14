package cse416.teamspurs.server.Representatives;

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

public class Reps {
    @Id
    private ObjectId id;

    private String first_name;

    private String last_name;

    private Integer district;

    private String party;

    private String race;

    private String race2;

    private String image;

    private String state;
}
