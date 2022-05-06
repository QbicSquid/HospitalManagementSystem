package com.hosp.model;

import java.io.Serializable;

public class Medicine implements Serializable {
	private String id;
	private String name;
	private int cost;
	private String description;
	
	
	
	public Medicine(String id, String name, int cost, String description) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}
	
	
	public Medicine() {
		// TODO Auto-generated constructor stub
	}
	


	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getCost() {
		return cost;
	}
	public String getDescription() {
		return description;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
