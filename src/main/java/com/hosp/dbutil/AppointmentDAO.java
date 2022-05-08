package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import com.hosp.commonutil.EditID;
import com.hosp.commonutil.InvalidIDException;

public class AppointmentDAO {
	private Connection con;

	public AppointmentDAO() {
		try {
			con = Conn.getDBConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String insertDocAccpointmnet (String date_time, String remarks, String doctorID) {
		String appointmentID = insertAppointment(date_time, remarks, doctorID, "AD");
		return appointmentID;
	}
	
	public String insertLabAccpointmnet (String date_time, String remarks, String labID) {
		String appointmentID = insertAppointment(date_time, remarks, labID, "AL");
		return appointmentID;
	}
	
	private String insertAppointment(String date_time, String remarks, String doctorOrLabID, String idPrefix) {
		String appointmentID, query;
		PreparedStatement preparedStatement;
		
		appointmentID = getNextAppointmentID(idPrefix);
		query = "insert into appointment values (?, ?, ?, ?, ?, NULL);";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, appointmentID);
			preparedStatement.setString(2, date_time);
			preparedStatement.setString(3, remarks);
			
			if (idPrefix.equals("AD")) {
				preparedStatement.setString(4, doctorOrLabID);
				preparedStatement.setNull(5, Types.CHAR);
			} else if (idPrefix.equals("AL")) {
				preparedStatement.setString(5, doctorOrLabID);
				preparedStatement.setNull(4, Types.CHAR);
			} else {
				throw new SQLException("Invalid docrtor or lab ID");
			}
			
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return appointmentID;
	}
	
	private String getNextAppointmentID(String idPrefix) {
		String docAppID = "";
		String query;
		PreparedStatement preparedStatement;
		ResultSet rs;
		
		query = "SELECT id "
				+ "FROM appointment "
				+ "WHERE id LIKE ? "
				+ "ORDER BY id DESC "
				+ "LIMIT 1;";
		
		idPrefix += "%";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, idPrefix);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				docAppID = EditID.incrementID(rs.getString(1));
			} else {
				docAppID = idPrefix + "001";
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
		
		query = "update appointment set paymentID=? where id=?;";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, paymentID);
			preparedStatement.setString(2, appointmentID);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteAppointment(String appointmentID) {
		String query;
		PreparedStatement preparedStatement;
		
		query = "DELETE FROM appointment WHERE id=?;";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, appointmentID);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void updateAppointment(String appointmentID, String date_time, String remarks) {
		String query;
		PreparedStatement preparedStatement;
		
		query = "UPDATE appointment SET "
				+ "date_time=?, "
				+ "remarks=? "
				+ "WHERE id=?;";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, date_time);
			preparedStatement.setString(2, remarks);
			preparedStatement.setString(3, appointmentID);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
