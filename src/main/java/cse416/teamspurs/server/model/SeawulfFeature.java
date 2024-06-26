package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "seawulf-features")
@Getter
public class SeawulfFeature {
    @Id
    private String id;

    private String type;
    private Object geometry;
    private Map<String, Object> properties;

    private State state;
    private Integer plan;
    private Integer district;
}
