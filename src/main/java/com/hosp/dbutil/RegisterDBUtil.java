package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.hosp.commonutil.EditID;
import com.hosp.commonutil.InvalidIDException;
//import com.hosp.model.User;

public class RegisterDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	
public static boolean insertuser(String username, String password, String firstname, String middlename, String lastname) {
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = Conn.getDBConnection();
    		stmt = con.createStatement();
    		
    		String userId= getUserID();
    		String sql = "insert into user values ('"+userId+"','"+username+"','"+password+"','"+firstname+"','"+middlename+"','"+lastname+"')";
    		int count = stmt.executeUpdate(sql);
    		
    		if(count > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
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
