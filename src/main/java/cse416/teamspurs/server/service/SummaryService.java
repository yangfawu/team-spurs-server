package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.GeoJsonFeature;
import cse416.teamspurs.server.model.Representative;
import cse416.teamspurs.server.model.StateDemographic;
import cse416.teamspurs.server.model.StateVoterDistribution;
import cse416.teamspurs.server.repository.GeoJsonFeatureRepository;
import cse416.teamspurs.server.repository.RepresentativeRepository;
import cse416.teamspurs.server.repository.StateDemographicRepository;
import cse416.teamspurs.server.repository.StateVoterDistributionRepository;

@Service
public class SummaryService {

    @Autowired
    private GeoJsonFeatureRepository featureRepo;

    @Autowired
    private StateDemographicRepository demoRepo;

    @Autowired
    private RepresentativeRepository repRepo;

    @Autowired
    private StateVoterDistributionRepository disRepo;

    @Cacheable("assembly-plan")
    public List<GeoJsonFeature> getAssemblyPlanByState(State state) {
        return featureRepo.findDistrictFeaturesByState(state);
    }

    @Cacheable("state-demographic")
    public StateDemographic getStateDemographic(State state) {
        return demoRepo.findByState(state);
    }

    @Cacheable("state-representatives")
    public List<Representative> getRepresentativesByState(State state) {
        return repRepo.findByState(state);
    }

    @Cacheable("state-voter-distribution")
    public StateVoterDistribution getStateVoterDistribution(State state) {
        return disRepo.findByState(state);
    }

}
