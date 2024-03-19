package cse416.teamspurs.server.dto;

import java.util.List;

import cse416.teamspurs.server.model.District;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HeatMapDto {
    private Integer min;
    private Integer max;
    private Integer total;
    private List<District> districts;
}
