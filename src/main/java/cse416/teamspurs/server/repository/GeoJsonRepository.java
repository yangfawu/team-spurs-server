package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.GeoJson;

@Repository
public interface GeoJsonRepository extends MongoRepository<GeoJson, String> {

    @Query(value = "{ level: 'state' }")
    public List<GeoJson> findAllStateGeoJsons();

    @Query(value = "{ level: 'district', state: ?0 }", fields = """
            {
                state: 1,
                type: 1,
                geometry: 1,
                "properties.district": 1
            }
            """)
    public List<GeoJson> findDistrictGeoJsonsByState(State state);

    @Query(value = "{ level: 'district', state: ?0 }", fields = """
            {
                state: 1,
                type: 1,
                geometry: 1,
                "properties.district": 1,
                "properties.heat_value": "$properties.?1"
            }
            """)
    public List<GeoJson> findHeatGeoJsonsByStateAndGroup(State state, Group group);

}
