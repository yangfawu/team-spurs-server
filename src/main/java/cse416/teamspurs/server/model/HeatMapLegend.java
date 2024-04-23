package cse416.teamspurs.server.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.HeatLevel;
import cse416.teamspurs.server.constant.State;
import lombok.Getter;

@Document(collection = "heat-map-legend")
@Getter
public class HeatMapLegend {
    @Id
    private String id;

    private State state;
    private Group group;
    private HeatLevel level;

    private List<Bin> bins;

    @Getter
    public static class Bin {
        private String color;
        private Integer min;
        private Integer max;
    }

}
