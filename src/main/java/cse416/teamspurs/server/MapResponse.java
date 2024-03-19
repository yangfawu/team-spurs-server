package cse416.teamspurs.server;

import cse416.teamspurs.server.District.District;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
public class MapResponse {
    private Integer min;
    private Integer max;
    private Integer total;
    private List <District> districts;

    public Integer getMin()
    {
        return min;
    }

    public void setMin(Integer num)
    {
        min = num;
    }

    public Integer getMax()
    {
        return max;
    }

    public void setmax(Integer num)
    {
        max = num;
    }

    public Integer getTotal()
    {
        return total;
    }

    public void setTotal(Integer num)
    {
        total = num;
    }

    public List <District> getDistricts()
    {
        return districts;
    }

    public void setDistricts(List <District> district_input)
    {
        districts = district_input;
    }
}
