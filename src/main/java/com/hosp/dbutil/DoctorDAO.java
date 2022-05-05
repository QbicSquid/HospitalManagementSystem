package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		DoctorSchedule schedule[] = null;
		String query;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		int size = 0, i = 0;
		
		query = "SELECT * FROM doctorSchedule WHERE id=?;";
		try {
			preparedStatement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setString(1, doctorID);
			resultSet = preparedStatement.executeQuery();
			
			if (!resultSet.last()) {
				return null;
			}
			size = resultSet.getRow();
			schedule = new DoctorSchedule[size];
			resultSet.first();
			
			while (resultSet.next()) {
				schedule[i].setDoctorID(resultSet.getString(1));
				schedule[i].setDayOfWeek(resultSet.getString(2));
				schedule[i].setStartTime(resultSet.getString(3));
				schedule[i].setEndTime(resultSet.getString(4));
				i++;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return schedule;
	}
	
	public Doctor[] getDoctors() {
		Doctor doctors[] = null;
		String query;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		int size = 0, i = 0;
		
		query = "SELECT * FROM doctor;";
		try {
			preparedStatement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = preparedStatement.executeQuery();
			
			if (!resultSet.last()) {
				return null;
			}
			size = resultSet.getRow();
			doctors = new Doctor[size];
			resultSet.first();
			
			while (resultSet.next()) {
				doctors[i].setId(resultSet.getString(1));
				doctors[i].setFirstName(resultSet.getString(2));
				doctors[i].setMiddleName(resultSet.getString(3));
				doctors[i].setLastName(resultSet.getString(4));
				doctors[i].setSpecialization(resultSet.getString(5));
				doctors[i].setGender(resultSet.getString(6).charAt(0));
				doctors[i].setDob(resultSet.getString(7));
				doctors[i].setCost(resultSet.getDouble(8));
				i++;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return doctors;
	}
}
