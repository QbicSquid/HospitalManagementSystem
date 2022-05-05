package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hosp.commonutil.EditID;
import com.hosp.commonutil.InvalidIDException;
import com.hosp.model.Appointment;

public class DocAppointmentDAO {
	private Connection con;

	public DocAppointmentDAO() {
		try {
			con = Conn.getDBConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String insertAppointment(String date_time, String remarks, String doctorID) {
		String docAppID, query;
		PreparedStatement preparedStatement;
		
		docAppID = getNextDocAppointmentID();
		query = "insert into appointment values (?, ?, ?, ?, NULL, NULL);";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, docAppID);
			preparedStatement.setString(2, date_time);
			preparedStatement.setString(3, docAppID);
			preparedStatement.setString(4, doctorID);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return docAppID;
	}
	
	private String getNextDocAppointmentID() {
		String docAppID = "";
		String query;
		PreparedStatement preparedStatement;
		ResultSet rs;
		
		query = "SELECT id "
				+ "FROM appointment "
				+ "WHERE id LIKE \"AD%\" "
				+ "ORDER BY id DESC "
				+ "LIMIT 1;";
		
		try {
			preparedStatement = con.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				docAppID = EditID.incrementID(rs.getString(1));
			} else {
				docAppID = "DA001";
			}	
			
		} catch (SQLException | InvalidIDException | NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return docAppID;
	}
	
	public void setPaymentID(String appointmentID, String paymentID) {
		String query;
		PreparedStatement preparedStatement;
		
		query = "update appointment set paymentID=\"?\" where id=\"?\";";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, paymentID);
			preparedStatement.setString(2, appointmentID);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
