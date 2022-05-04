package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hosp.commonutil.EditID;
import com.hosp.commonutil.InvalidIDException;

public class PaymentDAO {
	Connection con;
	
	public PaymentDAO() {
		try {
			con = Conn.getDBConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String insertPayment(String recieptID, String method) {
		String paymentID, query;
		PreparedStatement preparedStatement;
		
		paymentID = getNextPaymentID();
		query = "INSERT INTO payment VALUES (?, ?, ?)";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, paymentID);
			preparedStatement.setString(2, recieptID);
			preparedStatement.setString(3, method);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return paymentID;
	}
	
	private String getNextPaymentID() {

		String paymentID = "";
		String query;
		PreparedStatement preparedStatement;
		ResultSet rs;
		
		query = "SELECT id "
				+ "FROM payment "
				+ "ORDER BY id DESC "
				+ "LIMIT 1;";
		
		try {
			preparedStatement = con.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				paymentID = EditID.incrementID(rs.getString(1));
			} else {
				paymentID = "P_001";
			}	
			
		} catch (SQLException | InvalidIDException | NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return paymentID;
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
