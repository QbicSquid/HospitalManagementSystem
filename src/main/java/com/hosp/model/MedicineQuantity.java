package com.hosp.model;

import java.io.Serializable;

public class MedicineQuantity extends Medicine implements Serializable {
	
	private int quantity;	
	private double totalPrice;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void calcTotalPrice() {
		totalPrice = quantity * this.getCost();
	}
}
