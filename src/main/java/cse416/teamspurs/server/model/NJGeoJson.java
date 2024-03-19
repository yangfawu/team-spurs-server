package cse416.teamspurs.server.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "new-jersey-geojson")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NJGeoJson {

    @Id
    private ObjectId id;

    private String type;

    private List<org.bson.Document> features;

}
