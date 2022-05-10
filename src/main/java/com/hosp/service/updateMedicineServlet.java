package com.hosp.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hosp.dbutil.MedicineDAO;




public class updateMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private MedicineDAO getMedDAO;
		
		public updateMedicineServlet() {
				super();
				this.getMedDAO = new MedicineDAO();
		}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
				
				switch(servletPath) {
				
				case "/updateMedicineServlet":
					try{
						updateMedicine(request, response);
						System.out.println("order success ");
						} 
					catch(SQLException e) {
						e.printStackTrace();
						}
						break;
					
				}
				request.getRequestDispatcher("/views/updateSuccess.jsp").forward(request, response);
		}
		private void updateMedicine(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
				System.out.println("EditMed is Working");
				
				String id = request.getParameter("ordrId"); //take the auto generated id here
				System.out.println(id);
				
				//String custID = "UC001";
				String custID = request.getParameter("custId");
				System.out.println(custID);
				
				//String paymentID = "PO002";
				String paymentID = request.getParameter("paymentId");
				System.out.println(paymentID);
				
				String deliveryAddress = request.getParameter("deliveryAddress");
				System.out.println(deliveryAddress);
				
				getMedDAO.updateMedicine(id, custID, paymentID, deliveryAddress);
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/views/updateSuccess.jsp");
				//dispatcher.forward(request, response);
				//response.sendRedirect("/views/showStock.jsp");
				}
	
}

