package cse416.teamspurs.server.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.constant.HeatLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "heat-map-features")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeatMapFeature
{
    @Id
    private String id;

    private State state;
    private HeatLevel level;
    private Map<Group, Integer> bins;
    private String title;
    private Map<Group, Integer> demographic;
   

}
