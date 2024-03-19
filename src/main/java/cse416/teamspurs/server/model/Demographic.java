package cse416.teamspurs.server.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "demographic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demographic {
    @Id
    private ObjectId id;

    private String label;

    private Integer population;

    private Double percent_makeup;

    private String state;

    public Integer getPopulation() {
        return population;
    }
}
