package com.hosp.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hosp.dbutil.MedicineDAO;
import com.hosp.model.Medicine;
import com.hosp.model.MedicineQuantity;

public class placeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public placeOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("/views/stock.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String medname = request.getParameter("medname");
		MedicineDAO getMedDAO = new MedicineDAO();
		Medicine medicine = getMedDAO.getMedicine(medname); 
		
		System.out.println("Servlet joined");
		//converting Medicine object to an MedicineQuantity object
		MedicineQuantity medicineQuantity = new MedicineQuantity();
		medicineQuantity.setCost(medicine.getCost());
		medicineQuantity.setDescription(medicine.getDescription());
		medicineQuantity.setId(medicine.getId());
		medicineQuantity.setName(medicine.getName());
		
		request.setAttribute("medicineQty", medicineQuantity);
		
		request.getRequestDispatcher("/views/stock.jsp").forward(request, response);
	}

}
