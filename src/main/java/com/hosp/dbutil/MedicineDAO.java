package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;


import com.hosp.model.Medicine;
//import com.oop.model.item;
//import com.oop.util.DBConnect;




public class MedicineDAO {
	
	public Medicine getMedicine(String name) {
		
		Medicine medicine= new Medicine();
		
		Connection con;
		ResultSet rs;
	
		
		try {			
			con = Conn.getDBConnection();
			
			String query = "SELECT * " + 
					"FROM medicine " +
					"WHERE name = ?;";
			
			PreparedStatement preparedstatement = con.prepareStatement(query);
			preparedstatement.setString(1, name);
			
			rs = preparedstatement.executeQuery();
			
			
			
			if (!rs.next()) {
				throw new SQLException("Query returned 0 results.");
			}
			
			medicine.setId(rs.getString(1));
			medicine.setName(rs.getString(2));
			medicine.setCost(rs.getInt(3));
			medicine.setDescription(rs.getString(4));
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		return medicine;
		
		
	}
}
	/*
	//inserting values
	
	public static boolean insertmedicine() throws SQLException{
		
		Connection con;
		ResultSet rs1;
		con = Conn.getDBConnection();
		PreparedStatement preparedstatement = con.prepareStatement("INSERT INTO orderedmedicine VALUES "+" (?,?,?,?,?)");
		
		try {
			preparedstatement.setSring(1, orderID());
			preparedstatement.setInt(2, medNo());
			preparedstatement.setString(3, medicineID());
			preparedstatement.setInt(4, amount());
			preparedstatement.setString(5, dosage());
			
		
		long rs1=preparedstatement.executeLargeUpdate();
		
		if (rs1>0) {
			isSuccess=true;
		}
		
		else {
			isSuccess=false;
		}
		
		
		
	}catch(SQLException e) {
		
	}
		return isSuccess;
		
	}
	}
*/


/*

	public String insertOrderedMedicine(String orderID, int medNo, String medicineID, int amount, String dosage) {
				
			
		Connection con;
		ResultSet rs;
				
		String orderID1, query;
		PreparedStatement preparedStatement;
				
		orderID1 = getNextorderID();
				query = "INSERT INTO OrderedMedicine VALUES (?, ?, ?, ?, ?)";
				
				try {
					System.out.println("insertDAO is Working");
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, orderID);
					preparedStatement.setInt(2, medNo);
					System.out.println(""+ orderID + " " + orderID1);
					preparedStatement.setString(3, medicineID);
					preparedStatement.setInt(4, amount);
					preparedStatement.setString(5, dosage);
					
					preparedStatement.execute();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} 
				System.out.println(" return Working");
				return orderID1;
		}
			
		

		private String getNextorderID() {
				String orderID = "";
				String query;
				PreparedStatement preparedStatement;
				ResultSet rs;
				
				query = "SELECT orderID "
						+ "FROM OrderedMedicine "
						+ "ORDER BY orderID DESC "
						+ "LIMIT 1;";
				
				try {
					System.out.println("Nextorder is Working");
				    preparedStatement  = con.prepareStatement(query);
					rs = preparedStatement.executeQuery();
					
					if (rs.next()) {
						orderID= editID.incrementID(rs.getString(1));
						
					} else {
						orderID = "OM001";
						System.out.println("incStock is Working");
					}	
					
				} catch (SQLException | InvalidIDException | NumberFormatException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
				return orderID;
		}
*/
