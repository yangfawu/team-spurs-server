package cse416.teamspurs.server;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MapResponse {
    private Integer min;
    private Integer max;
    private Integer total;

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
}
