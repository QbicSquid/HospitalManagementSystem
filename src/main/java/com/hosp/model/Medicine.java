package com.hosp.model;

import java.io.Serializable;

public class Medicine implements Serializable {
	private String id;
	private String name;
	private double cost;
	private String description;



	public Medicine(String id, String name, int cost, String description) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}


	public Medicine() {

	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getCost() {
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
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
