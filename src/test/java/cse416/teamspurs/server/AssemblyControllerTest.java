package cse416.teamspurs.server;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cse416.teamspurs.server.service.AssemblyService;
import cse416.teamspurs.server.model.GeoJsonFeature;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.controller.AssemblyController;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest(AssemblyController.class)
public class AssemblyControllerTest {
    @MockBean
    AssemblyService service;

    @Test 
    void doesEachNJGeoJsonFeatureHaveDistrict()
    {
        List<GeoJsonFeature> map = service.getAssemblyPlanByState(State.nj);

        for(GeoJsonFeature feature : map)
            assertTrue(feature.getProperties() != null && feature.getProperties().containsKey("district") 
            , "District field does not exist in properties");
    }

    @Test 
    void doesEachVAGeoJsonFeatureHaveDistrict()
    {
        List<GeoJsonFeature> map = service.getAssemblyPlanByState(State.va);

        for(GeoJsonFeature feature : map)
            assertTrue(feature.getProperties() != null && feature.getProperties().containsKey("district") 
            , "District field does not exist in properties");
    }

}
