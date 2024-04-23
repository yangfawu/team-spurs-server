package cse416.teamspurs.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.GeoJsonFeature;

@Repository
public interface GeoJsonFeatureRepository extends MongoRepository<GeoJsonFeature, String> {

    @Query(value = "{ level: 'state' }")
    public List<GeoJsonFeature> findAllStateFeatures();

    @Query(value = "{ level: 'district', state: ?0 }", fields = """
            {
                state: 1,
                type: 1,
                geometry: 1,
                "properties.district": 1
            }
            """)
    public List<GeoJsonFeature> findDistrictFeaturesByState(State state);

}
