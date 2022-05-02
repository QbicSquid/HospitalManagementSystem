package com.hosp.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

import com.hosp.dbutil.Conn;
import java.sql.*;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con;
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		
		try {
			 con = Conn.getDBConnection();
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("");
			if(rs.next()) {
				response.sendRedirect("")
			}
		}catch (Exception e) {
			System.out.print(e.getMessage());
			}
	}

}
