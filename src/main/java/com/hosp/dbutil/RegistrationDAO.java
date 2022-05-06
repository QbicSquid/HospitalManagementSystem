package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hosp.model.User;

public class RegistrationDAO {
	

	public static int RegisterUser(User user) {
//		Connection con;
//		
//		String INSERT_USERS_SQL = "INSERT INTO employee" +
//	            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
//	            " (?, ?, ?, ?, ?,?,?);";
//
//	        int result = 0;
//	        
//			try {
//				con = Conn.getDBConnection();
//				
//					PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
//		            preparedStatement.setString(4, user.getUsername());
//		            preparedStatement.setString(5, user.getPassword());
//		            preparedStatement.setString(2, user.getFirstName());
//		            preparedStatement.setString(3, user.getMiddleName());
//		            preparedStatement.setString(3, user.getLastName());
//
//		            System.out.println(preparedStatement);
//		            
//		            result = preparedStatement.executeUpdate();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//				e.printStackTrace();
//			}
//			return result;
		
	}
	
	

}
