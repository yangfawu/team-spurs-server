package cse416.teamspurs.server.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "geojson")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateGeoJson {

    @Id
    private ObjectId Id;

    private String state;

    private GeoJson<?> collection;

}
