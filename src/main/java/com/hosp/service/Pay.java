package com.hosp.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hosp.payportal.PayPortal;
import com.hosp.dbutil.PaymentDAO;

/**
 * Servlet implementation class Pay
 */
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recieptID = PayPortal.pay();
		String appointmentID = (String)request.getAttribute("appointmentID"); // TODO: get the id here from a javabean instead
		String paymentID;
		String method = request.getParameter("method");
		PaymentDAO paymentDAO = new PaymentDAO();
		
		if (appointmentID == null) {
			throw new ServletException("appointment id not set");
		}
		
		paymentID = paymentDAO.insertPayment(recieptID, method);
		paymentDAO.setPaymentID(appointmentID, paymentID);
		
		// TODO: change the logic. To make this class usable by others, just put payment details in a bean and forward to appropriate servlet
		
		request.getRequestDispatcher("add path to view appointment page, possibly through appointment servlet").forward(request, response);
	}

}
