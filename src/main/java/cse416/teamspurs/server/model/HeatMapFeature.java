package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.HeatLevel;
import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "heat-map-features")
@Getter
public class HeatMapFeature {
    @Id
    private String id;

    private State state;
    private HeatLevel level;

    private String type;
    private Object geometry;
    private Map<String, Object> properties;

    private String title;
    private Map<Group, Integer> bins;
    private Map<Group, Integer> demographic;
}
