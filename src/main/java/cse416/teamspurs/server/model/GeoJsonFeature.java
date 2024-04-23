package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.GeoLevel;
import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "geojson")
@Getter
public class GeoJsonFeature {
    @Id
    private String id;

    private GeoLevel level;
    private State state;

    private String type;
    private Object geometry;
    private Map<String, Object> properties;
}
