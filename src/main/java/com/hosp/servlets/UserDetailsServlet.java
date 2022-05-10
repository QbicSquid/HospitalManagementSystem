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
			System.out.println("Check Session:"+username);
			
			User user;
			user = Getuser.getUserFromUsername(username);
			session.setAttribute("user", user);
			
			Customer customer;
			customer = CustomerDAO.getCustomer(user.getId());
			session.setAttribute("customer", customer);
			
			List<MedicalCondition> medicalCondition;
			medicalCondition = CustomerDAO.getMedicalCondition(user.getId());
			request.setAttribute("medicalCondition", medicalCondition);

			
			
		System.out.println("Check Session: "+user.getId());
		request.getRequestDispatcher("/views/Profile/viewProfile.jsp").forward(request, response);
//		System.out.println("Check doget");
//		response.getWriter().print("OK");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Check do post");
		
			
//			List<User> userDetails = new ArrayList<>();
			
//			User user1 = new User(id,username,password,firstname,middlename,lasstname);
//			userDetails.add(user1);
//			request.setAttribute("userDetails", userDetails);
			
			

//			ArrayList<User> userDetails = new ArrayList<>();
//			
//					static String id = user.getId();
//					String username = user.getPassword();
//					String email = rs.getString(3);
//					String phone = rs.getString(4);
//					String username = rs.getString(5);
//					String password = rs.getString(6);
//					
//					Customer cus = new Customer(id,name,email,phone,username,password);
//					customer.add(cus);
//			
//			List<Customer> cusDetails = CustomerDBUtil.getCustomer(userName);
//			request.setAttribute("cusDetails", cusDetails);

//			request.getRequestDispatcher("viewProfile.jsp").forward(request, response);/

		

	}
}
