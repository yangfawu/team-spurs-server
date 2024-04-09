package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.DistrictGeoJson;

@Repository
public interface DistrictGeoJsonRepository extends MongoRepository<DistrictGeoJson, String> {

    @Query(fields = """
            {
                "state": 1,
                "type": 1,
                "geometry": 1,
                "properties.district": 1
            }
            """)
    public List<DistrictGeoJson> findByState(State state);

    @Query(value = "{ state: ?0 }", fields = """
            {
                "state": 1,
                "type": 1,
                "geometry": 1,
                "properties.district": 1,
                "properties.heat_value": "$properties.?1"
            }
            """)
    public List<DistrictGeoJson> findByStateAndGroup(State state, Group group);

}
