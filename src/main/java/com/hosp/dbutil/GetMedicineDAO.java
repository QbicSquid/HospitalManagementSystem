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



public class GetMedicineDAO {
	
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
		public static List<Medicine> getSearchMedicine(String sname) throws SQLException{
			
			ArrayList<Medicine> Medicine1 = new ArrayList<>();
			
			
			//connection
			Connection con;
			con = Conn.getDBConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * " + 
											 "FROM medicine " +
											 "WHERE name = ?;");
			
			while(rs.next()) {
				
				String id = rs.getString(1);
				String name = rs.getString(2);
				int cost=rs.getInt(3);
				String description=rs.getString(4);
				
				
				
				
				Medicine i = new Medicine(id,name,cost,description);
				Medicine1.add(i);
			}
			
			return Medicine1;
			
		}

*/