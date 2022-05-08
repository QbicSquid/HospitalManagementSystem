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

	//update
	public void updateStock(String medicineID, String stockpileID, int amount) {
		System.out.println("Update stock function working");
		System.out.println(medicineID);
		System.out.println(stockpileID);
		System.out.println(amount);
		String query;
		PreparedStatement preparedStatement;
		
		query = "UPDATE stockpile SET amount = ? WHERE medicineID = ? AND stockpileID=?;";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(2, medicineID);
			preparedStatement.setString(3, stockpileID);
			preparedStatement.setInt(1, amount);
			System.out.println(preparedStatement.toString());
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
		
		query = "DELETE FROM stockpile WHERE medicineID = ? AND stockpileID=?;";
		
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
	
	//read

	public MedicineStock[] readStock() {
		String query;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		MedicineStock[] medicineStock = null;
		int size = 0, i = 0;
		
		query = "SELECT * FROM stockpile;";
		
		try {
			System.out.println("readDAO is Working");

			preparedStatement = con.prepareCall(query);
			preparedStatement.executeQuery();

			preparedStatement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.last()) {
				size = resultSet.getRow();
				resultSet.first();
				medicineStock = new MedicineStock[size];
				
				do {
					medicineStock[i] = new MedicineStock();
					medicineStock[i].setMedicineID(resultSet.getString(1));
					medicineStock[i].setStockpileID(resultSet.getString(2));
					medicineStock[i].setManuDate(resultSet.getString(3));
					medicineStock[i].setExpDate(resultSet.getString(4));
					medicineStock[i].setAmount(resultSet.getInt(5));
					
					i++;
				} while (resultSet.next());
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return medicineStock;
	}
	
}
