package com.hosp.model;

public class OrderedMedicine {
	private String orderID;
	private int medNo;
	private String medicineID;
	private int amount;
	private String dosage;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getMedNo() {
		return medNo;
	}
	public void setMedNo(int medNo) {
		this.medNo = medNo;
	}
	public String getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
}
