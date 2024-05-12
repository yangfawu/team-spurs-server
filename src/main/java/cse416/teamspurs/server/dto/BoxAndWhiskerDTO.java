package cse416.teamspurs.server.dto;

import java.util.List;

import cse416.teamspurs.server.model.EnsembleBoxAndWhisker;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoxAndWhiskerDTO {
    private List<Double> enacted;
    private List<EnsembleBoxAndWhisker> boxes;
}
