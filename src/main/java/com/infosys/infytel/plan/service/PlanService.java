package com.infosys.infytel.plan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infytel.plan.dto.PlanDTO;
import com.infosys.infytel.plan.entity.Plan;
import com.infosys.infytel.plan.repository.PlanRepository;

@Service
public class PlanService {

	@Autowired
	PlanRepository repo;

	public List<PlanDTO> getAllPlans() {

		List<Plan> plans = repo.findAll();
		List<PlanDTO> listPlansDTO = new ArrayList<PlanDTO>();
		for (Plan plan : plans) {
			PlanDTO dto = PlanDTO.valueOf(plan);
			listPlansDTO.add(dto);
		}
		return listPlansDTO;
	}
	
	public List<String> getAllPlanNames() {

		List<Plan> plans = repo.findAll();
		List<String> listPlansNames = new ArrayList<String>();
		for (Plan plan : plans) {
			listPlansNames.add(plan.getPlanName());
		}
		return listPlansNames;
	}

	public PlanDTO getSpecificPlan(int planId) {
		return PlanDTO.valueOf(repo.findOne(planId));
	}

	public void addPlan(PlanDTO planDTO) {
		Plan plan = PlanDTO.createEntity(planDTO);
		repo.save(plan);
	}

	public void updatePlan(PlanDTO planDTO) {
		PlanDTO dto = PlanDTO.valueOf(repo.findOne(planDTO.getPlanId()));
		if (dto != null) {
			Plan plan = PlanDTO.createEntity(planDTO);
			repo.save(plan);
		}
	}

	public void deletePlan(Integer id) {
		repo.delete(id);
	}
}
