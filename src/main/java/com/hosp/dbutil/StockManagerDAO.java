package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.hosp.commonutil.EditID;
import com.hosp.commonutil.InvalidIDException;
import com.hosp.model.MedicineStock;

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
	
	//insert
	public String insertStock(String medicineID, String manuDate, String expDate, int amount) {
		String stockpileID, query;
		PreparedStatement preparedStatement;
		
		stockpileID = getNextStockpileID();
		query = "INSERT INTO stockpile VALUES (?, ?, ?, ?, ?)";
		
		try {
			System.out.println("insertDAO is Working");
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, medicineID);
			preparedStatement.setString(2, stockpileID);
			System.out.println(""+ medicineID + " " + stockpileID);
			preparedStatement.setString(3, manuDate);
			preparedStatement.setString(4, expDate);
			preparedStatement.setInt(5, amount);
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		System.out.println(" return Working");
		return stockpileID;
	}
	
	private String getNextStockpileID() {
		String stockpileID = "";
		String query;
		PreparedStatement preparedStatement;
		ResultSet rs;
		
		query = "SELECT stockpileID "
				+ "FROM stockpile "
				+ "ORDER BY stockpileID DESC "
				+ "LIMIT 1;";
		
		try {
			System.out.println("NextStock is Working");
			preparedStatement = con.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				stockpileID= EditID.incrementID(rs.getString(1));
				
			} else {
				stockpileID = "S_001";
				System.out.println("incStock is Working");
			}	
			
		} catch (SQLException | InvalidIDException | NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return stockpileID;
	}
/*
	
	//update
	public void updateStock(String medicineID, String stockpileID, int amount) {
		String query;
		PreparedStatement preparedStatement;
		ResultSet rs;
		
		query = "UPDATE stockpile SET amount = ? WHERE stockpileID=? AND medicineID = ?;";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, amount);
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	//delete
	public void deleteStock(String medicineID, String stockpileID) {
		String  query;
		PreparedStatement preparedStatement;
		
		query = "DELETE FROM stockpile WHERE stockpileID=? AND medicineID = ?;";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,medicineID);
			preparedStatement.setString(2,stockpileID);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	*/
	
	//read
	public void readStock() {
		String query;
		PreparedStatement preparedStatement;
		ResultSet rs;
		query = "SELECT * FROM stockpile;";
		
		try {
			System.out.println("readDAO is Working");
			preparedStatement = con.prepareCall(query);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
