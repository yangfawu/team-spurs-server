package cse416.teamspurs.server.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cse416.teamspurs.server.constant.Group;

@Component
public class StringToGroupConverter implements Converter<String, Group> {

    @Override
    public Group convert(String source) {
        switch (source) {
            case "hl":
                return Group.HISPANIC_LATINO;
            case "white":
                return Group.WHITE;
            case "black":
                return Group.BLACK;
            case "aian":
                return Group.AMERICAN_INDIAN_ALASKA_NATIVE;
            case "asian":
                return Group.ASIAN;
            case "hpi":
                return Group.HAWAIIAN_PACIFIC_ISLANDER;
            case "other":
                return Group.OTHER;
            case "mixed":
                return Group.MIXED;
            default:
                return null;
        }
    }

}
