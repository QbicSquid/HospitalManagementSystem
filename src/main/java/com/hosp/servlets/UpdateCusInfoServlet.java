package com.hosp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.hosp.dbutil.CustomerDAO;
import com.hosp.dbutil.Getuser;
import com.hosp.model.Customer;
import com.hosp.model.MedicalCondition;
import com.hosp.model.User;

public class UpdateCusInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user;
		HttpSession session = request.getSession();
		if (session.getAttribute("user")!=null) {
			user = (User)session.getAttribute("user");
			String firstName = request.getParameter("firstname");
			String middleName = request.getParameter("middlename");
			String lastName = request.getParameter("lastname");
	        String contactNo = request.getParameter("contact");
			String email = request.getParameter("email");
	        String address = request.getParameter("address");
	        String dob = request.getParameter("dob");
	        String gender = request.getParameter("gender");
	        
	        boolean custCheck;
	        boolean isTrue1;
	        boolean isTrue2;
	        
	        custCheck = CustomerDAO.isExistingCustomer(user.getId());
	        
	        if(custCheck==true) {
	        
	        isTrue1 = CustomerDAO.updateCustomerInfo(user.getId(), contactNo, email, address, dob);
	        isTrue2 = CustomerDAO.updateUserInfo(user.getId(), firstName, middleName, lastName);
	        
	        	if(isTrue1 == true && isTrue2== true) {
	        	
	        		User user1;
	        		user = Getuser.getUserFromUsername(user.getUsername());
	        		session.setAttribute("user", user);
				
	        		Customer customer;
	        		customer = CustomerDAO.getCustomer(user.getId());
	        		session.setAttribute("customer", customer);
	        	
	        		List<MedicalCondition> medicalCondition;
	        		medicalCondition = CustomerDAO.getMedicalCondition(user.getId());
	        		request.setAttribute("medicalCondition", medicalCondition);
	        	
	        		request.getRequestDispatcher("/views/Profile/viewProfile.jsp").forward(request, response);
				

	        	} else {
	        		request.getRequestDispatcher("/views/Profile/failed.jsp").forward(request, response);
	        	}
	        }else {
	        	boolean insertCheck;
	        	
	        	insertCheck = CustomerDAO.insertCustomerInfo(user.getId(),contactNo,email,address,dob,gender);
	        
	        	if(insertCheck==true) {
				
	        		Customer customer;
	        		customer = CustomerDAO.getCustomer(user.getId());
	        		session.setAttribute("customer", customer);
	        	
	        		List<MedicalCondition> medicalCondition;
	        		medicalCondition = CustomerDAO.getMedicalCondition(user.getId());
	        		request.setAttribute("medicalCondition", medicalCondition);
	        	
	        		request.getRequestDispatcher("/views/Profile/viewProfile.jsp").forward(request, response);
				

	        	} else {
	        		request.getRequestDispatcher("/views/Profile/failed.jsp").forward(request, response);
	        	}
	        }
	       }
			
			
			
		}
		
	}

