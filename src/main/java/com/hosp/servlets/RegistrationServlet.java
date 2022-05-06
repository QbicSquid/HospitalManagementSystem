package com.hosp.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hosp.dbutil.RegisterDBUtil;
import com.hosp.dbutil.RegistrationDAO;
import com.hosp.model.User;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private RegistrationDAO reg;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/views/Registration/registration.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		response.setContentType("text/html");
//		System.out.println("DEBUG LINE 1");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
        String middleName = request.getParameter("middleName");
        
//        System.out.println("DEBUG LINE " + username);
        boolean isTrue;
//        boolean iTrue= true;
		
		isTrue = RegisterDBUtil.insertuser(username, password, firstName, middleName, lastName);
//		System.out.println("DEBUG LINE 10");
//		System.out.println("DEBUG LINE "+isTrue);
		
//		request.getRequestDispatcher("/views/Registration/success.jsp").forward(request, response);
		
		if(isTrue == true) {
			request.getRequestDispatcher("/views/Registration/success.jsp").forward(request, response);
			
//			RequestDispatcher dis = request.getRequestDispatcher("/views/Registration/success.jsp");
//			dis.forward(request, response);
//			System.out.println("DEBUG LINE 11");
		} else {
			request.getRequestDispatcher("/views/Registration/unsuccess.jsp").forward(request, response);
			
//			RequestDispatcher dis2 = request.getRequestDispatcher("/views/Registration/unsuccess.jsp");
//			dis2.forward(request, response);
//			System.out.println("DEBUG LINE 12");
		}
        
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setMiddleName(middleName);
//        
//        try {
//            RegistrationDAO.RegisterUser(user);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        request.getRequestDispatcher("").forward(request, response);
    }
     

}
