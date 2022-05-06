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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		
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
					readStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
				
		}
				/*
			//Insert
			case "/ManageNewStock":
	
				try {
					 insertStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				break;
				*/
			/*
			case "/delete":
				try {
					deleteStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
	
				break;
				
				
			case "/update":
				try{
					updateStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
	
			default:
				try{
					readStock(request, response);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		*/
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Show New form is Working");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("/views/stock.jsp").forward(request, response);
	}
	
	
	//Read
	private void readStock(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		System.out.println("readStock is Working");
		String stockpileID = request.getParameter("stockpileID");
		String medicineID = request.getParameter("medicineID");
		String manuDate = request.getParameter("manuDate");
		String expDate = request.getParameter("expDate");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		stockManager.readStock(stockpileID, medicineID, manuDate, expDate, amount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/showStock.jsp");
		dispatcher.forward(request, response);
	}
	
	/*
	//Read Stock info by ID
	private void stockEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int medicineID = Integer.parseInt(request.getParameter("medicineID"));
		MedicineStock stockExist = stockManager.selectStock(medicineID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("stockForm.jsp");
		request.setAttribute("manageMedicineStock", stockExist);
		dispatcher.forward(request, response);
	
	}
	*/
	
	//Insert
	private void insertStock(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.println("insertStock is Working");
		String medicineID = request.getParameter("medicineID");
		String manuDate = request.getParameter("manuDate");
		String expDate = request.getParameter("expDate");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		stockManager.insertStock(medicineID, manuDate, expDate, amount); //calling the method to save the new stock to DB
		//response.sendRedirect("/views/stock.jsp");
	}
	
	/*
	//Update
	private void updateStock(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.println("UpdateStock is Working");
		String medicineID = request.getParameter("medicineID");
		String stockpileID = request.getParameter("stockpileID");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		stockManager.updateStock(medicineID, stockpileID, amount);
		response.sendRedirect("stockList");
	}
	
	//Delete
	private void deleteStock(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		System.out.println("DeleteStock is Working");
		String medicineID = request.getParameter("medicineID");
		String stockpileID = request.getParameter("stockpileID");
		
		stockManager.deleteStock(medicineID, stockpileID);
		response.sendRedirect("stockList");
	
	}
	*/

}
