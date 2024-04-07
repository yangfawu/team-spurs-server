package cse416.teamspurs.server.dto;

import java.util.List;

import cse416.teamspurs.server.model.GeoJson;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeatMapDTO {
    private int min;
    private int max;
    private List<GeoJson> features;
}
