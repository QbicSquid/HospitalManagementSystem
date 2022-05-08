package com.hosp.service;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hosp.dbutil.MedicineDAO;



public class insertMedicineServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MedicineDAO getMedDAO;
	
	public insertMedicineServlet() {
			super();
			this.getMedDAO = new MedicineDAO();
	}
	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String servletPath = request.getServletPath();
		
		switch(servletPath) {
		
		case "/insertMedicineServlet":
			try{
				insertOrderedMedicine(request, response);
				} 
			catch(SQLException e) {
				e.printStackTrace();
				}
				break;
			
		}
	}
	private void insertOrderedMedicine(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException{
		
		//System.out.println("insertStock is Working");
		
		
		int medNo = Integer.parseInt(request.getParameter("medNo"));
		String medicineID = request.getParameter("medicineID");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String dosage = request.getParameter("dosage");
		
		getMedDAO.insertOrderedMedicine(medNo, medicineID, amount, dosage); //calling the method to save the new stock to DB
		//response.sendRedirect("/views/stock.jsp");
	
}	
}