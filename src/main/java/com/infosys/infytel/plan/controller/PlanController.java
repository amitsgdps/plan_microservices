package com.infosys.infytel.plan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infytel.plan.dto.PlanDTO;
import com.infosys.infytel.plan.service.PlanService;

@RestController
// @EnableAutoConfiguration

public class PlanController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlanService planService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/plans", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlanDTO> getAllPlans() {
		logger.info("======== getAllPlans ===========");
		return planService.getAllPlans();
	}

	@GetMapping(value = "/plannames", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllPlanNames() {
		logger.info("======== getAllPlanNames ===========");
		return planService.getAllPlanNames();
	}

	@GetMapping(value = "/plans/{planId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PlanDTO getAllPlans(@PathVariable int planId) {
		logger.info("======== getAllPlans =========== planId : {}", planId);
		if(planId == 0) {
			logger.error("======== getAllPlans planId is 0 ===========");
			throw new RuntimeException();
		}
		return planService.getSpecificPlan(planId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/plans/add_plans", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void savePlan(@RequestBody PlanDTO planDTO) {
		logger.trace("======== savePlan =========== planDTO : {}", planDTO);
		planService.addPlan(planDTO);
	}

	@PutMapping(value = "/plans/update_plans", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updatePlan(@RequestBody PlanDTO planDTO) {
		logger.trace("======== updatePlan =========== planDTO : {}", planDTO);
		planService.updatePlan(planDTO);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value = "/plans/delete_plans/{planId}")
	public void deletePlan(@PathVariable Integer planId) {
		logger.debug("======== deletePlan =========== planId : {}", planId);
		planService.deletePlan(planId);
	}
}
