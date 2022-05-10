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
import com.hosp.model.MedicalCondition;
import com.hosp.model.User;

public class MedicalConditionServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user;
		HttpSession session = request.getSession();
		if (session.getAttribute("user")!=null) {
			user = (User)session.getAttribute("user");
			String conId =request.getParameter("conId");
			
			if(conId != null) {
				CustomerDAO.deleteMedicalCondition(Integer.parseInt(conId));
			}
			List<MedicalCondition> medicalCondition;
			medicalCondition = CustomerDAO.getMedicalCondition(user.getId());
			request.setAttribute("medicalCondition", medicalCondition);

		}
		
		request.getRequestDispatcher("/views/Profile/viewProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		HttpSession session = request.getSession();
		if (session.getAttribute("user")!=null) {
			user = (User)session.getAttribute("user");
			String medcon =request.getParameter("medcon");
			
			if(medcon != null) {
				CustomerDAO.insertMedicalCondition(user.getId(), medcon);
			}
			List<MedicalCondition> medicalCondition;
			medicalCondition = CustomerDAO.getMedicalCondition(user.getId());
			request.setAttribute("medicalCondition", medicalCondition);
		}
		
		

	request.getRequestDispatcher("/views/Profile/viewProfile.jsp").forward(request, response);
	}
}
