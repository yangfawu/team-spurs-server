package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: rename collection to district-geojson when done
@Document(collection = "geojson")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictGeoJson {
    @Id
    private String id;

    private String type;
    private Object geometry;
    private Map<String, Object> properties;
    private State state;
}
