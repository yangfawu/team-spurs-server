package cse416.teamspurs.server.District;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "district-demographic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
    @Id
    private ObjectId Id;

    private Integer district;

    private Integer total_population;

    private Integer hispanic_latino;

    private Integer white;

    private Integer black;

    private Integer american_indian_alaska_native;

    private Integer asian;

    private Integer hawaiian_pacific_islander;

    private Integer other;

    private Integer mixed;

    private String state;
}
