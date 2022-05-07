package com.hosp.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.hosp.dbutil.MedicineDAO;
import com.hosp.dbutil.cartDAO;

//import javax.servlet.RequestDispatcher;

import com.hosp.model.Medicine;
import com.hosp.model.MedicineQuantity;
import com.oop.model.item;
import com.oop.service.itemDBUtil;

import java.util.ArrayList;
import java.util.List;

public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public cartServlet() {
        super();
       
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("/views/searchMedicine.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			/*double medi = MedicineQuantity.getTotalPrice();
			request.setAttribute("medicine", medi);
			//redirect to the view
			request.getRequestDispatcher("/views/cart.jsp").forward(request, response);*/
			
		
		
	}
	

}
