package com.hosp.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class addtocartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public addtocartServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String id =request.getParameter("medicineID");
		//String name =request.getParameter("name");
		//request.getSession().setAttribute(id, ${ medicineQty.id });
		
		//request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
		
	}

}