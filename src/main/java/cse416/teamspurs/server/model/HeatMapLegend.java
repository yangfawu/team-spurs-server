package cse416.teamspurs.server.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.HeatLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "heat-map-legends")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeatMapLegend 
{
    @Id
    private String id;

    private State state;
    private Group group;
    private HeatLevel level;
    private List<Bin> bins;

    public static class Bin
    {
        private String color;
        private Integer min;
        private Integer max;
    }

}
