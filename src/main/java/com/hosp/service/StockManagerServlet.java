package com.hosp.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hosp.dbutil.StockManagerDAO;
import com.hosp.model.MedicineStock;

/**
 * Servlet implementation class StockManagerServlet
 */
//inheritance
public class StockManagerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private StockManagerDAO stockManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	//DAO constructor
    public StockManagerServlet() {
    	this.stockManager = new StockManagerDAO();	        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/views/showStock.jsp").forward(request, response);
		//System.out.println("get is working");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("post is working");
		switch (action) {
		
			case "/addNewStock":
				showNewForm(request, response);
				break;
				
			case "/ManageStock":
				
				//insert
				try {
					 insertStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				showNewForm(request,response);
				break; 
				
			case "/stockList":
				
				//read
				try{
					System.out.println("Read switch case is working");  //debug
					readStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case "/Edit":
				System.out.println("Edit switch case is working"); //debug
				try{
					EditStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case "/Update":
				System.out.println("Update switch case is working");  //debug
				try{
					updateStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case "/delete":
				try {
					deleteStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
		
				break;
				
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Show New form is Working");//debug
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/stock.jsp");
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("/views/stock.jsp").forward(request, response);
	}
	
	
	//Read
	private void readStock(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		System.out.println("readStock is Working"); //debug
		String stockpileID = request.getParameter("stockpileID");
		String medicineID = request.getParameter("medicineID");
		String manuDate = request.getParameter("manuDate");
		String expDate = request.getParameter("expDate");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		stockManager.readStock();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/showStock.jsp");
		dispatcher.forward(request, response);
	}
	
	
	//Insert
	private void insertStock(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		
		System.out.println("insertStock is Working");//debug
		String medicineID = request.getParameter("medicineID");
		String manuDate = request.getParameter("manuDate");
		String expDate = request.getParameter("expDate");
		int amount = Integer.parseInt(request.getParameter("amount"));
		System.out.println(medicineID);
		System.out.println(manuDate);
		System.out.println(expDate);
		System.out.println(amount);
		
		
		stockManager.insertStock(medicineID, manuDate, expDate, amount); //calling the method to save the new stock to DB
		//response.sendRedirect("/views/stock.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/showStock.jsp");
		dispatcher.forward(request, response);
	}
	
	
	//Update
	private void EditStock(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		System.out.println("EditStock is Working"); //debug
		String medicineID = request.getParameter("medicineIDs");
		System.out.println(medicineID);
		String stockpileID = request.getParameter("stockpileIDs");
		System.out.println(stockpileID);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/updateStock.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("/views/showStock.jsp");
	}
	
	private void updateStock(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		System.out.println("UpdateStock is Working"); //debug
		String medicineID = request.getParameter("medicineID");
		System.out.println(medicineID);
		String stockpileID = request.getParameter("stockpileID");
		System.out.println(stockpileID);
		int amount = Integer.parseInt(request.getParameter("amount"));
		System.out.println(amount);
		
		stockManager.updateStock(medicineID, stockpileID, amount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/showStock.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("/views/showStock.jsp");
	}

	//delete
	private void deleteStock(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		System.out.println("DeleteStock is Working");//debug
		String medicineID = request.getParameter("medicineIDs");
		System.out.println(medicineID);
		String stockpileID = request.getParameter("stockpileIDs");
		System.out.println(stockpileID);
		
		stockManager.deleteStock(medicineID, stockpileID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/showStock.jsp");
		dispatcher.forward(request, response);
	
	}	


}
