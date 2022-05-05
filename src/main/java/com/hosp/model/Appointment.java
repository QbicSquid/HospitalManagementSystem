package com.hosp.model;

import java.io.Serializable;

public class Appointment implements Serializable {
	String id;
	String date_time;
	String remarks;
	String doctorID;
	String labTestID;
	String paymentID;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getLabTestID() {
		return labTestID;
	}
	public void setLabTestID(String labTestID) {
		this.labTestID = labTestID;
	}
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
}
