package cse416.teamspurs.server.model;

import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "district-geojson")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class DistrictGeoJson extends PropertiesLessGeoJson {
    private Properties properties;

    public static class Properties extends HashMap<String, Object> {

        public Integer getDistrict() {
            return (Integer) get("district");
        }

    }
}
