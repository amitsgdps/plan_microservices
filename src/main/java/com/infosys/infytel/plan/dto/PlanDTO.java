package com.infosys.infytel.plan.dto;

import com.infosys.infytel.plan.entity.Plan;

public class PlanDTO {

	Integer planId;
	String planName;
	Integer nationalRate;
	Integer localRate;

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Integer getNationalRate() {
		return nationalRate;
	}

	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}

	public Integer getLocalRate() {
		return localRate;
	}

	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}

	@Override
	public String toString() {
		return "PlanDTO [planId=" + planId + ", planName=" + planName + ", nationalRate=" + nationalRate
				+ ", localRate=" + localRate + "]";
	}

	public static PlanDTO valueOf(Plan plan) {
		PlanDTO planDTO = null;
		if(plan != null) {
		planDTO = new PlanDTO();
		planDTO.setPlanId(plan.getPlanId());
		planDTO.setPlanName(plan.getPlanName());
		planDTO.setLocalRate(plan.getLocalRate());
		planDTO.setNationalRate(plan.getNationalRate());
		} 
		return planDTO;
	}
	
	public static Plan createEntity(PlanDTO planDTO) {
		Plan plan = new Plan();
		plan.setPlanId(planDTO.getPlanId());
		plan.setPlanName(planDTO.getPlanName());
		plan.setLocalRate(planDTO.getLocalRate());
		plan.setNationalRate(planDTO.getNationalRate());
		return plan;
	}

}
