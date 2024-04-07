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
                return Group.hispanic_latino;
            case "white":
                return Group.white;
            case "black":
                return Group.black;
            case "aian":
                return Group.american_indian_alaska_native;
            case "asian":
                return Group.asian;
            case "hpi":
                return Group.hawaiian_pacific_islander;
            case "other":
                return Group.other;
            case "mixed":
                return Group.mixed;
            default:
                return null;
        }
    }

}
