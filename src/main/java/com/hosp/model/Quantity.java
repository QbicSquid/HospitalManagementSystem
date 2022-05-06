package com.hosp.model;

public class Quantity extends Medicine {
	
	private int quantity;	
	private float tprice = quantity*getCost();
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTprice() {
		return tprice;
	}
	public void setTprice(float tprice) {
		this.tprice = tprice;
	}
	
	



}
