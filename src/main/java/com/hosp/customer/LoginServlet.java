package com.hosp.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import testel.TestBean;

import java.io.IOException;
import java.io.PrintWriter;

import com.hosp.dbutil.Getuser;
import com.hosp.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("/views/Login/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		User user = Getuser.getUserFromUsername(username);
		
		System.out.println("DEBUG LINE " + username); // debug line
		System.out.println("DEBUG LINE " + user.getUsername()); // debug line
		
		System.out.println("DEBUG LINE " + password); // debug line
		System.out.println("DEBUG LINE " + user.getPassword()); // debug line
		
		if (password.equals(user.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			
			request.getRequestDispatcher("/views/Login/loginsuccess.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/Login/loginfail.jsp").forward(request, response);
		}
	}

}
