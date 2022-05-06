package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.hosp.commonutil.EditID;
import com.hosp.commonutil.InvalidException;
import com.hosp.model.User;

public class RegisterDBUtil {
	
//	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	
public static boolean insertuser(String username, String password, String firstname, String middlename, String lastname) {
    	
    	boolean isSuccess = false;
    	
//    	System.out.println("DEBUG LINE 2");
    	
    	try {
//    		System.out.println("DEBUG LINE 3");
    		con = Conn.getDBConnection();
    		stmt = con.createStatement();
//    		System.out.println("DEBUG LINE 4");
    		
//    		PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
//    		
//            preparedStatement.setString(2, user.getUsername());
//            preparedStatement.setString(3, user.getPassword());
//            preparedStatement.setString(4, user.getFirstName());
//            preparedStatement.setString(5, user.getMiddleName());
//            preparedStatement.setString(6, user.getLastName());
//
//            System.out.println(preparedStatement);
    		
    		String userId= getUserID();
//    		String id="UC002";
    		String sql = "insert into user values ('"+userId+"','"+username+"','"+password+"','"+firstname+"','"+middlename+"','"+lastname+"')";
    		int count = stmt.executeUpdate(sql);
//    		System.out.println("DEBUG LINE 5");
    		
    		if(count > 0) {
    			isSuccess = true;
//    			System.out.println("DEBUG LINE 6");
    		} else {
    			isSuccess = false;
//    			System.out.println("DEBUG LINE 7");
    		}
    		
    	}
    	catch (Exception e) {
//    		System.out.println("DEBUG LINE 8");
    		e.printStackTrace();
    	}
//    	System.out.println("DEBUG LINE 9");
//    	System.out.println("DEBUG LINE "+isSuccess);
    	return isSuccess;
    }

	private static String getUserID(){
		String userID ="";
		PreparedStatement preparedStatement;
		ResultSet rs;
		
		String sql = "SELECT id "+ "FROM user "+ "ORDER BY id DESC "+ "LIMIT 1;";
		
		try {
			preparedStatement = con.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				userID = EditID.incrementID(rs.getString(1));
			} else {
				userID = "UC001";
			}	
			
		} catch (SQLException | InvalidIDException | NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return userID;
	
}

}
