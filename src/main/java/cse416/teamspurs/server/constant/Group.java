package cse416.teamspurs.server.constant;

import lombok.Getter;

public enum Group {
    HISPANIC_LATINO("hispanic_latino"),
    WHITE("white"),
    BLACK("black"),
    AMERICAN_INDIAN_ALASKA_NATIVE("american_indian_alaska_native"),
    ASIAN("asian"),
    HAWAIIAN_PACIFIC_ISLANDER("hawaiian_pacific_islander"),
    OTHER("other"),
    MIXED("mixed");

    @Getter
    private final String label;

    Group(String label) {
        this.label = label;
    }

}
