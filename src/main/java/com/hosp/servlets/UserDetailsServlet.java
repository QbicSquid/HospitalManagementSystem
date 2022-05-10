package com.hosp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hosp.dbutil.CustomerDAO;
import com.hosp.dbutil.Getuser;
import com.hosp.model.Customer;
import com.hosp.model.MedicalCondition;
import com.hosp.model.User;

public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username;
		HttpSession session = request.getSession();
		if (session.getAttribute("username")!=null) {
			username = (String)session.getAttribute("username");
			
			User user;
			user = Getuser.getUserFromUsername(username);
			session.setAttribute("user", user);
			
			Customer customer;
			customer = CustomerDAO.getCustomer(user.getId());
			session.setAttribute("customer", customer);
			
			List<MedicalCondition> medicalCondition;
			medicalCondition = CustomerDAO.getMedicalCondition(user.getId());
			request.setAttribute("medicalCondition", medicalCondition);

			
			
//		System.out.println("Check Session: "+user.getId());
		request.getRequestDispatcher("/views/Profile/viewProfile.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("Check do post");
		
					

	}
}
