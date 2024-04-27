package cse416.teamspurs.server.dto;

import java.util.List;

import cse416.teamspurs.server.model.PrecinctPoint;
import cse416.teamspurs.server.model.RegressionLine;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PrecinctAnalysisDTO {

    private List<PrecinctPoint> rows;
    private List<RegressionLine> lines;

}
