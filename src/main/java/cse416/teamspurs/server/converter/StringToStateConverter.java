package cse416.teamspurs.server.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cse416.teamspurs.server.constant.State;

@Component
public class StringToStateConverter implements Converter<String, State> {

    @Override
    public State convert(String source) {
        switch (source) {
            case "nj":
                return State.NJ;
            case "va":
                return State.VA;
            default:
                return null;
        }
    }

}
