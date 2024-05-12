package cse416.teamspurs.server.dto;

import java.util.List;

import cse416.teamspurs.server.model.HeatMapFeature;
import cse416.teamspurs.server.model.HeatMapLegend;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HeatMapDTO {
    private List<HeatMapFeature> features;
    private HeatMapLegend legend;
}
