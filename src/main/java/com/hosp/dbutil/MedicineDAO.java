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

