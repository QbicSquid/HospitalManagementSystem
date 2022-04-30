package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hosp.model.User;

public class Getuser {
	
	public User getUser(String userid) {
		User user = new User();
		Connection con;
		ResultSet rs;
		
		try {			
			con = Conn.getDBConnection();
			
			String query = "SELECT * " + 
					"FROM user " +
					"WHERE id=?;";
			
			PreparedStatement preparedstatement = con.prepareStatement(query);
			preparedstatement.setString(1, userid);
			
			rs = preparedstatement.executeQuery();
			
			if (!rs.next()) {
				throw new SQLException("Query returned 0 results.");
			}
			
			user.setId(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setFirstName(rs.getString(4));
			user.setMiddleName(rs.getString(5));
			user.setLastName(rs.getString(6));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return user;
	}
}
