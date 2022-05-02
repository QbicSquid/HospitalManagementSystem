package com.hosp.dbutil;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;

public class Conn {
	private static Connection connection;
	
	public static Connection getDBConnection() throws SQLException {
		
		if (connection == null) {			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospdb", "hospadmin", "pass");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return connection;
	}
}
