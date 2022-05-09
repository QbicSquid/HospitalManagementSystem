package com.hosp.model;

public class MedicineOrder {
	private String id;
	private String deliveryAddress;
	private String deliveryState;
	private String Date;
	private String custID;
	private String paymentID;
	
	public String getMedicineOrderID() {
		return id;
	}
	public void setMedicineOrderID(String medicineOrderID) {
		id = medicineOrderID;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	
	
}
