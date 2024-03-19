package cse416.teamspurs.server.constant;

import lombok.Getter;

public enum State {
    NJ("New Jersey"), VA("Virginia");

    @Getter
    private final String label;

    State(String label) {
        this.label = label;
    }

}
