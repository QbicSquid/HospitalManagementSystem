package com.hosp.model;

public class MedicalCondition {
	private int conditionId;
	private String userId;
	private String description;
	
	public MedicalCondition(int conditionId, String userId, String description) {
		this.conditionId = conditionId;
		this.userId = userId;
		this.description = description;
	}
	
	
	public int getConditionId() {
		return conditionId;
	}
	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
