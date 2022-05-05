package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import com.hosp.commonutil.EditID;
import com.hosp.commonutil.InvalidIDException;

public class StockManagerDAO {
	
	Connection con;
	
	public StockManagerDAO() {
		try {
			con = Conn.getDBConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String insertStock( String medicineID,String manuDate, String expDate, int amount) {
		String stockpileID, query;
		PreparedStatement preparedStatement;
		
		stockpileID = getNextStockpileID();
		query = "INSERT INTO stockpile VALUES (?, ?, ?, ?)";
		
		try {
			java.util.Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("manuDate"));
			java.sql.Date selectedSQLDate =  new java.sql.Date(selectedDate.getTime());
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicineID);
			preparedStatement.setString(2, manuDate);
			preparedStatement.setString(3, expDate);
			preparedStatement.setInt(4, amount);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return stockpileID;
	}
	
	private String getNextStockpileID() {
		String stockpileID = "";
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
				stockpileID= EditID.incrementID(rs.getString(1));
			} else {
				stockpileID = "S_001";
			}	
			
		} catch (SQLException | InvalidIDException | NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return stockpileID;
	}
	
	public String updateStock(String medicineID,String manuDate, String expDate, int amount) {
		String stockpileID, query;
		PreparedStatement preparedStatement;
		
		query = "UPDATE stockpile SET (?, ?, ?, ?) WHERE stockpileID /? ";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicineID);
			preparedStatement.setString(2, manuDate);
			preparedStatement.setString(3, expDate);
			preparedStatement.setInt(4, amount);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public String deleteStock(String medicineID,String manuDate, String expDate, int amount) {
		String stockpileID, query;
		PreparedStatement preparedStatement;
		
		query = "UPDATE stockpile SET (?, ?, ?, ?) WHERE /?";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicineID);
			preparedStatement.setString(2, manuDate);
			preparedStatement.setString(3, expDate);
			preparedStatement.setInt(4, amount);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return stockpileID;
	}
}
