package com.hosp.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hosp.dbutil.GetMedicineDAO;
import com.hosp.model.Medicine;

public class placeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public placeOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("/views/temporaryinput.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html");
		//PrintWriter out =response.getWriter();
		
//		String id =request.getParameter("id");
//		String name =request.getParameter("name");
//		String cost =request.getParameter("cost");
//		String description =request.getParameter("description");
		
		String medname = request.getParameter("medname");
		GetMedicineDAO getMedDAO = new GetMedicineDAO();
		Medicine medicine = getMedDAO.getMedicine(medname);
		
		request.setAttribute("medicine", medicine);
		
		request.getRequestDispatcher("/views/temporaryoutput.jsp").forward(request, response);
	}

}
