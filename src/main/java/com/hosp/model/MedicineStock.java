package com.hosp.model;

public class MedicineStock {
	private String medicineID;
	private String stockpileID;
	private String manuDate;
	private String expDate;
	private int amount;
	
	public MedicineStock() {
	}
	
	public MedicineStock(String medicineID, String stockpileID, String manuDate, String expDate, int amount) {
		super();
		this.medicineID = medicineID;
		this.stockpileID = stockpileID;
		this.manuDate = manuDate;
		this.expDate = expDate;
		this.amount = amount;
	}
	
	public MedicineStock(String stockpileID, String manuDate, String expDate, int amount) {
		super();
		this.stockpileID = stockpileID;
		this.manuDate = manuDate;
		this.expDate = expDate;
		this.amount = amount;
	}

	public String getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}
	public String getStockpileID() {
		return stockpileID;
	}
	public void setStockpileID(String stockpileID) {
		this.stockpileID = stockpileID;
	}
	public String getManuDate() {
		return manuDate;
	}
	public void setManuDate(String manuDate) {
		this.manuDate = manuDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
		
}
