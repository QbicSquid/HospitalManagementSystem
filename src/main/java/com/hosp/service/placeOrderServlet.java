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
		
		request.getRequestDispatcher("/views/searchMedicine.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html");
		//PrintWriter out =response.getWriter();
		
//		String id =request.getParameter("id");
//		String name =request.getParameter("name");
//		String cost =request.getParameter("cost");
//		String description =request.getParameter("description");
		
		String medname = request.getParameter("medname");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		MedicineDAO getMedDAO = new MedicineDAO();
		Medicine medicine = getMedDAO.getMedicine(medname); 
		
		
		// converting Medicine object to an MedicineQuantity object
		MedicineQuantity medicineQuantity = new MedicineQuantity();
		medicineQuantity.setCost(medicine.getCost());
		medicineQuantity.setDescription(medicine.getDescription());
		medicineQuantity.setId(medicine.getId());
		medicineQuantity.setName(medicine.getName());
		medicineQuantity.setQuantity(quantity);
		medicineQuantity.calcTotalPrice();
		
		request.setAttribute("medicineQty", medicineQuantity);
		
		request.getRequestDispatcher("/views/searchMedicine.jsp").forward(request, response);
	}
	

}
