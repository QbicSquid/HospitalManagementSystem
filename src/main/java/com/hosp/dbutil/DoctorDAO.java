package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

import com.hosp.model.DoctorSchedule;
import com.hosp.model.Doctor;

public class DoctorDAO {
	private Connection con;

	public DoctorDAO() {
		try {
			con = Conn.getDBConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public DoctorSchedule[] getSchedule(String doctorID) {
		DoctorSchedule schedule[];
	}
	
	public Doctor[] getDoctors() {
		Doctor doctors[];
	}
}
