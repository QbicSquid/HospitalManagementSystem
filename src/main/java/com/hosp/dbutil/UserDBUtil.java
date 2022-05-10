package com.hosp.dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hosp.model.Customer;

public class UserDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
//public static List<Customer> getCustomer(String userName) {
//		
//		ArrayList<Customer> customer = new ArrayList<>();
//		
//		try {
//			
//			con = Conn.getDBConnection();
//			stmt = con.createStatement();
//			String sql = "select * from customer where username='"+userId+"'";
//			rs = stmt.executeQuery(sql);
//			
//			while (rs.next()) {
//				int id = rs.getInt(1);
//				String name = rs.getString(2);
//				String email = rs.getString(3);
//				String phone = rs.getString(4);
//				String username = rs.getString(5);
//				String password = rs.getString(6);
//				
//				Customer cus = new Customer(id,name,email,phone,username,password);
//				customer.add(cus);
//			}
//			
//		} catch (Exception e) {
//			
//		}
//		
//		return customer;	
//	}
	
	

}
