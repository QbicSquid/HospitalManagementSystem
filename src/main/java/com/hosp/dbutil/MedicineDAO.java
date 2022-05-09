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
	
	public MedicineDAO() {
		try {
			con = Conn.getDBConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Medicine getMedicine(String name) {
		Medicine medicine= new Medicine();
		ResultSet rs;
		
		try {						
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

	public String insertmedicineOrder(String deliveryAddress, String deliveryState, String Date, String custID, String paymentID) {	
		
		
		String id, query;
		PreparedStatement preparedStatement;
				
		id = getNextid();
				query = "INSERT INTO medicineOrder VALUES (?, ?, ?, ?, ?, ?)";
				
				try {
					System.out.println("insertDAO is Working");
					preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, id);
					preparedStatement.setString(2, deliveryAddress);
					
					System.out.println(""+ id + " " + id);
					
					preparedStatement.setString(3, deliveryState);
					preparedStatement.setString(4, Date);
					preparedStatement.setString(5, custID);
					preparedStatement.setString(6, paymentID);
					
					preparedStatement.execute();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				} 
				System.out.println(" return Working");
				
				return id;
		}
			
		

		private String getNextid() {
				String id = "";
				String query;
				PreparedStatement preparedStatement;
				ResultSet rs1;
				
				query = "SELECT id "
						+ "FROM medicineOrder "
						+ "ORDER BY id DESC "
						+ "LIMIT 1;";
				
				try {
					System.out.println("Nextorder is Working");
				    preparedStatement  = con.prepareStatement(query);
					rs1 = preparedStatement.executeQuery();
					
					if (rs1.next()) {
						
						id= EditID.incrementID(rs1.getString(1));
						
					} else {
						id = "MO001";
						System.out.println("incStock is Working");          
					}	
					
				} catch (SQLException | InvalidIDException | NumberFormatException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
				return id;
		}
		
		//update
		public void updateMedicine(String custID, String paymentID, String deliveryAddress) {
			System.out.println("Update med function working");
			System.out.println(custID);
			System.out.println(paymentID);
			System.out.println(deliveryAddress);
			String query;
			PreparedStatement preparedStatement;

			query = "UPDATE medicineOrder SET amount = ? WHERE custID = ? AND paymentID=?;";

			try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(2, custID);
			preparedStatement.setString(3, paymentID);
			preparedStatement.setString(1, deliveryAddress);
			System.out.println(preparedStatement.toString());
			preparedStatement.execute();


			} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			}

			}

		//delete
		public void deleteOrder(String custID, String paymentID) {
			String query;
			PreparedStatement preparedStatement;

			query = "DELETE FROM medicineOrder WHERE custID = ? AND paymentID=?;";

			try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,custID);
			preparedStatement.setString(2,paymentID);
			preparedStatement.execute();

			} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			}

			}

}