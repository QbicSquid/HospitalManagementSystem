package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;


import com.hosp.model.Medicine;
import com.hosp.commonutil.InvalidIDException;
import com.hosp.commonutil.EditID;
//import com.oop.model.item;
//import com.oop.util.DBConnect;




public class MedicineDAO {
	private Connection con;
	
	public Medicine getMedicine(String name) {
		
		Medicine medicine= new Medicine();
		
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
	
	//insertdata

	public String insertOrderedMedicine(int medNo, String medicineID, int amount, String dosage) {	
		
		
		String orderID, query;
		PreparedStatement preparedStatement;
				
		orderID = getNextorderID();
				query = "INSERT INTO OrderedMedicine VALUES (?, ?, ?, ?, ?)";
				
				try {
					System.out.println("insertDAO is Working");
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, orderID);
					preparedStatement.setInt(2, medNo);
					System.out.println(""+ orderID + " " + orderID);
					preparedStatement.setString(3, medicineID);
					preparedStatement.setInt(4, amount);
					preparedStatement.setString(5, dosage);
					
					preparedStatement.execute();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} 
				System.out.println(" return Working");
				return orderID;
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
						orderID= EditID.incrementID(rs.getString(1));
						
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
		
		//update
		public void updateMedicine(int amount) {
			System.out.println("Update stock function working");
			System.out.println(amount);
			//System.out.println(stockpileID);
			//System.out.println(amount);
			String query;
			PreparedStatement preparedStatement;

			query = "UPDATE OrderedMedicine SET amount = ? WHERE medicineID = ? AND stockpileID=?;";

			try {
			preparedStatement = con.prepareStatement(query);
			//preparedStatement.setString(2, medicineID);
			//preparedStatement.setString(3, stockpileID);
			preparedStatement.setInt(1, amount);
			System.out.println(preparedStatement.toString());
			preparedStatement.execute();


			} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			}

			}
		//delete
		public void deleteOrder(String medicineID, String stockpileID) {
			String query;
			PreparedStatement preparedStatement;

			query = "DELETE FROM OrderedMedicine WHERE medicineID = ? AND stockpileID=?;";

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

}