package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.Group;
import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.GeoJsonFeature;
import cse416.teamspurs.server.model.OpportunityDistrictDistributionBar;
import cse416.teamspurs.server.model.OpportunityDistrictInfo;
import cse416.teamspurs.server.model.RedistrictingInfo;
import cse416.teamspurs.server.model.Representative;
import cse416.teamspurs.server.model.StateDemographic;
import cse416.teamspurs.server.model.StateVoterDistribution;
import cse416.teamspurs.server.repository.GeoJsonFeatureRepository;
import cse416.teamspurs.server.repository.OpportunityDistrictDistributionBarRepository;
import cse416.teamspurs.server.repository.OpportunityDistrictInfoRepository;
import cse416.teamspurs.server.repository.RedistrictingInfoRepository;
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

    @Autowired
    private OpportunityDistrictInfoRepository opportunityDistrictInfoRepo;

    @Autowired
    private RedistrictingInfoRepository redRepo;

    @Autowired
    private OpportunityDistrictDistributionBarRepository odBarRepo;

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

    @Cacheable("opportunity-districts")
    public List<OpportunityDistrictInfo> getOpportunityDistrictInfos(State state, Integer threshold) {
        return opportunityDistrictInfoRepo.findByStateAndThreshold(state, threshold);
    }

    @Cacheable("state-redistricting-info")
    public RedistrictingInfo getStateRedistrictingInfo(State state) {
        return redRepo.findByState(state);
    }

    @Cacheable("ensemble-opportunity-district-distribution")
    public List<OpportunityDistrictDistributionBar> getEnsembleOpportunityDistrictDistribution(State state, Group group,
            String threshold) {
        return odBarRepo.findByStateAndGroupAndThreshold(state, group, threshold);
    }

}
