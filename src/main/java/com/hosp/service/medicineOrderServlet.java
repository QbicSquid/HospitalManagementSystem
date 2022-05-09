package com.hosp.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hosp.dbutil.MedicineDAO;

public class medicineOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
private MedicineDAO getMedDAO;
	
	public medicineOrderServlet() {
			super();
			this.getMedDAO = new MedicineDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
				
				switch(servletPath) {
				
				case "/medicineOrderServlet":
					try{
						insertmedicineOrder(request, response);
						System.out.println("order success ");
						} 
					catch(SQLException e) {
						e.printStackTrace();
						}
						break;
						
				
				request.getRequestDispatcher("/views/index.jsp").forward(request, response);
			}
	
			private void insertmedicineOrder(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException{
				
				System.out.println("insertStock is Working");
				
				
		
				System.out.println("debug line 1");
				
				String deliveryAddress = request.getParameter("deliveryAddress");
				String deliveryState = request.getParameter("deliveryState");
				String Date = request.getParameter("Date");
				String custID = "UC001";
				//String custID = request.getParameter("custID");
				String paymentID = "PO002";
				//String paymentID = request.getParameter("paymentID");
				
				System.out.println("debug line 4");
				
				System.out.println("debug line ");
				
				getMedDAO.insertmedicineOrder(deliveryAddress, deliveryState, Date, custID, paymentID); 
				System.out.println("order inserted ");
				
				
			
		}	
}



