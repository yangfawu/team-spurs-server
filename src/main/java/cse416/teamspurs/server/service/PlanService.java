package cse416.teamspurs.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cse416.teamspurs.server.constant.State;
import cse416.teamspurs.server.model.SeawulfFeature;
import cse416.teamspurs.server.model.SeawulfPlan;
import cse416.teamspurs.server.repository.SeawulfFeatureRepository;
import cse416.teamspurs.server.repository.SeawulfPlanRepository;

@Service
public class PlanService {

    @Autowired
    private SeawulfPlanRepository planRepo;

    @Autowired
    private SeawulfFeatureRepository featureRepo;

    @Cacheable("stateEnsemblePlanOptions")
    public List<SeawulfPlan> getStateEnsemblePlanOptions(State state) {
        return planRepo.findByState(state);
    }

    @Cacheable("stateEnsemblePlan")
    public List<SeawulfFeature> getStateEnsemblePlan(State state, Integer plan) {
        return featureRepo.findByStateAndPlan(state, plan);
    }

}
