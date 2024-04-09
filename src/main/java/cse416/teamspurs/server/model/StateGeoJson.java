package cse416.teamspurs.server.model;

import org.springframework.data.mongodb.core.mapping.Document;

import cse416.teamspurs.server.constant.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "state-geojson")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StateGeoJson extends PropertiesLessGeoJson {    
    private Properties properties;

    @Data
    public static class Properties {
        private State state;
    }
}
