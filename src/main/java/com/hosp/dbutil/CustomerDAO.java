package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hosp.model.Customer;
import com.hosp.model.MedicalCondition;

public class CustomerDAO {
		
		public static Customer getCustomer(String userid){
			Customer customer = new Customer();
			Connection con;
			ResultSet rs;
			
			try {			
				con = Conn.getDBConnection();
				String query = "SELECT * " + "FROM customer " +"WHERE userID=?;";
				
				PreparedStatement preparedstatement = con.prepareStatement(query);
				preparedstatement.setString(1, userid);
				
				rs = preparedstatement.executeQuery();
				
				if (rs.next()) {
					customer.setId(rs.getString(1));
					customer.setContact(rs.getString(2));
					customer.setEmail(rs.getString(3));
					customer.setAddress(rs.getString(4));
					customer.setDob(rs.getString(5));
					customer.setGender(rs.getString(6));
				}
				

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			return customer;
		}

		
		public static boolean insertMedicalCondition(String userId, String description) {
			Connection con;
			Statement stmt;
			
			boolean isSuccess = false;
			try {
	    		con = Conn.getDBConnection();
	    		stmt = con.createStatement();
	    		
	    		String sql = "insert into medicalcondition(customerID, medicondition ) values ('"+userId+"','"+description+"')";
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
		
		public static boolean deleteMedicalCondition(int conditionId) {
			Connection con;
			Statement stmt;
			
			boolean isSuccess= false;
			try {
	    		con = Conn.getDBConnection();
	    		stmt = con.createStatement();
	    		
	    		String sql = "DELETE FROM medicalcondition where conditionID='"+conditionId+"'";
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
		
		
		public static List<MedicalCondition> getMedicalCondition(String userId){
			Connection con;
			Statement stmt;
			ResultSet rs;
			
			List<MedicalCondition> medicalConditions = new ArrayList<MedicalCondition>();
		try {
			con = Conn.getDBConnection();
			stmt = con.createStatement();
			
			String sql = "select * from medicalcondition where customerID=?";
			PreparedStatement preparedstatement = con.prepareStatement(sql);
			preparedstatement.setString(1, userId);
			
			rs = preparedstatement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String userid = rs.getString(2);
				String descripition = rs.getString(3);
				MedicalCondition medicalCondition = new MedicalCondition(id, userid, descripition);
				medicalConditions.add(medicalCondition);
				
//				System.out.println("check description:"+descripition);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return medicalConditions;
		}
		
		public static boolean isExistingCustomer(String userid) {
			Connection con;
			Statement stmt;
			ResultSet rs;
			boolean isSuccess= false;
			try {
	    		con = Conn.getDBConnection();
	    		stmt = con.createStatement();
	    		String query = "SELECT * " + "FROM customer " +"WHERE userID=?;";
				
				PreparedStatement preparedstatement = con.prepareStatement(query);
				preparedstatement.setString(1, userid);
				
				rs = preparedstatement.executeQuery();
				
				if (rs.next()) {
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
			
		
		
		public static boolean insertCustomerInfo(String userId,String contactNo,String email,String address,String dob,String gender) {
			Connection con;
			Statement stmt;
			
			boolean isSuccess= false;
			try {
	    		con = Conn.getDBConnection();
	    		stmt = con.createStatement();
	    		
	    		
	    		String sql = "insert into customer values ('"+userId+"','"+contactNo+"','"+email+"','"+address+"','"+dob+"','M')";
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
		
		public static boolean updateCustomerInfo(String userId,String contactNo,String email,String address,String dob) {
			Connection con;
			Statement stmt;
			PreparedStatement preparedstatement = null;
			Date sqlDate = Date.valueOf(dob);
			
			boolean isSuccess= false;
			try {
	    		con = Conn.getDBConnection();
	    		stmt = con.createStatement();
	    		
	    		
	    		String sql = "UPDATE customer SET contactNo = ?, email = ?, address = ?, dob = ? WHERE userID= ?";
	    		
	    		preparedstatement = con.prepareStatement(sql);
				preparedstatement.setString(1, contactNo);
				preparedstatement.setString(2, email);
				preparedstatement.setString(3, address);
				preparedstatement.setDate(4, sqlDate);
				preparedstatement.setString(5, userId);
				
	    		int count = preparedstatement.executeUpdate();
	    		
	    		if(count > 0) {
	    			isSuccess = true;
	    		} else {
	    			isSuccess = false;
	    		}
	    		
			
			}
			catch (Exception e) {
	    		e.printStackTrace();
	    	}finally {
				if(preparedstatement != null) {
					try {
						preparedstatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
//			System.out.println("checke return in 1:"+isSuccess);
			return isSuccess;
			
		}
		
		public static boolean updateUserInfo(String userId,String firstname,String middlename,String lastname) {
			Connection con;
			Statement stmt;
			ResultSet rs;
			PreparedStatement preparedstatement = null;
			
//			System.out.println("check userID:"+userId);
			boolean isSuccess= false;
			try {
	    		con = Conn.getDBConnection();
	    		stmt = con.createStatement();
	    		
	    		String sql = "UPDATE user SET firstName = ?, middleName = ?, lastName =? WHERE id=?;";
	    		
	    		preparedstatement = con.prepareStatement(sql);
				
				preparedstatement.setString(1, firstname);
				preparedstatement.setString(2, middlename);
				preparedstatement.setString(3, lastname);
				preparedstatement.setString(4, userId);
				
				int count = preparedstatement.executeUpdate();
	    		
	    		if(count>0) {
	    			isSuccess = true;
	    		} else {
	    			isSuccess = false;
	    		}
			
			}
			catch (Exception e) {
	    		e.printStackTrace();
	    	}
//			System.out.println("checke return in 2:"+isSuccess);
			return isSuccess;
			
		}
}
