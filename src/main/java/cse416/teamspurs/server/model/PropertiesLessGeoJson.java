package cse416.teamspurs.server.model;

import org.springframework.data.annotation.Id;

import cse416.teamspurs.server.constant.State;
import lombok.Data;

@Data
public class PropertiesLessGeoJson {
    @Id
    private String id;

    private State state;
    private String type;
    private Object geometry;
}
