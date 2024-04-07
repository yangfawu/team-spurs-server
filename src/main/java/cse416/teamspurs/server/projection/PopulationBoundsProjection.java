package cse416.teamspurs.server.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopulationBoundsProjection {
    private int min;
    private int max;
}
