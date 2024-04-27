package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document(collection = "seawulf-features")
@Getter
public class SeawulfFeature {
    @Id
    private String id;

    // private State state;

    private String type;
    private Object geometry;
    private Map<String, Object> properties;

    private Integer plan;
}
