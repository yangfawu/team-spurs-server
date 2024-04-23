package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.model.GeoJsonFeature;
import cse416.teamspurs.server.repository.GeoJsonFeatureRepository;

@Service
public class MiscService {

    @Autowired
    private GeoJsonFeatureRepository jsonRepo;

    @Cacheable("all-states")
    public List<GeoJsonFeature> getAllStates() {
        return jsonRepo.findAllStateFeatures();
    }

}
