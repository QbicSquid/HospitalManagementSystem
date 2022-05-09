package com.hosp.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class updateMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public updateMedicineServlet() {
        super();
 
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
		}
		private void updateMedicine(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			
				System.out.println("EditStock is Working");
				//String medicineID = request.getParameter("medicineIDs");
				//System.out.println(medicineID);
				//String stockpileID = request.getParameter("stockpileIDs");
				//System.out.println(stockpileID);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/searchMedicine.jsp");
				dispatcher.forward(request, response);
				//response.sendRedirect("/views/showStock.jsp");
				}
}


