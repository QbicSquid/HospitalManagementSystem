package com.hosp.servlets;

//import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException; 
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hosp.dbutil.RegisterDBUtil;
//import com.hosp.dbutil.RegistrationDAO;
//import com.hosp.model.User;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/views/Registration/registration.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
        String middleName = request.getParameter("middleName");
        
        boolean isTrue;
		
		isTrue = RegisterDBUtil.insertuser(username, password, firstName, middleName, lastName);
		
		if(isTrue == true) {
			request.getRequestDispatcher("/views/Registration/success.jsp").forward(request, response);
			

		} else {
			request.getRequestDispatcher("/views/Registration/unsuccess.jsp").forward(request, response);

		}
        
    }
     

}
