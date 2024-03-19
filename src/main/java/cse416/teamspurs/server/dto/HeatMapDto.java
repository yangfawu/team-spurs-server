package cse416.teamspurs.server.dto;

import java.util.Map;

import cse416.teamspurs.server.model.District;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeatMapDto {
    private int min;
    private int max;
    private String key;
    private Map<Integer, District> table;
    private Object map;
}
