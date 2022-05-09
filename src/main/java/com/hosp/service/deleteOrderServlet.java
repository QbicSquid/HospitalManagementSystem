package com.hosp.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hosp.dbutil.MedicineDAO;


public class deleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
    	private MedicineDAO getMedDAO;
    	
    	public deleteOrderServlet() {
    			super();
    			this.getMedDAO = new MedicineDAO();
    	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		
		switch(servletPath) {
		
		case "/deleteOrderServlet":
			try{
				deleteOrder(request, response);
				System.out.println("order success ");
				} 
			catch(SQLException e) {
				e.printStackTrace();
				}
				break;
			
		}
	}
		private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
				System.out.println("DeleteStock is Working");
				String custID = request.getParameter("custID");
				System.out.println(custID);
				String paymentID = request.getParameter("paymentID");
				System.out.println(paymentID);
				getMedDAO.deleteOrder(custID, paymentID);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cart.jsp");
				dispatcher.forward(request, response);
				}
}


