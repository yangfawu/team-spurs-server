package cse416.teamspurs.server.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cse416.teamspurs.server.constant.HeatLevel;

@Component
public class StringtoHeatLevelConverter implements Converter<String, HeatLevel> {

    @Override
    public HeatLevel convert(String source) {
        switch (source) {
            case "precinct":
                return HeatLevel.precinct;
            case "census":
                return HeatLevel.census;
            case "county":
                return HeatLevel.county;
            default:
                return null;
        }
    }

}
