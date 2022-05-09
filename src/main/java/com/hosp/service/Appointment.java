package com.hosp.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hosp.dbutil.AppointmentDAO;
import com.hosp.dbutil.DoctorDAO;
import com.hosp.model.Doctor;
import com.hosp.model.DoctorSchedule;
import com.hosp.commonutil.Pay;

/**
 * Servlet implementation class DocAppointment
 */
public class Appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appointment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		
		switch (servletPath) {
		case "/DocAppointment":
			showDoctors(request, response);
			break;
		case "/DocSchedule":
			showSchedule(request, response);
			break;
		case "/DocAppointmentConfirm":
			confirmDocAppointment(request, response);
			break;
		case "/AppointmentPay":
			pay(request, response);
			break;
		case "/AppointmentPayConfirm":
			payConfirm(request, response);
			break;
		case "/UpdateAppointment":
			updateAppointment(request, response);
			break;
		case "/AppointmentPayUpdated":
			payUpdated(request, response);
			break;
		case "/CancelAppointment":
			cancelAppointment(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
				
	}

	private void showDoctors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorDAO doctorDAO = DoctorDAO.getDoctorDao();
		Doctor[] doctors = doctorDAO.getDoctors();
		request.setAttribute("doctors", doctors);
		request.getRequestDispatcher("/views/appointment/doctors.jsp").forward(request, response);
	}
	
	private void showSchedule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorDAO doctorDAO = DoctorDAO.getDoctorDao();
		DoctorSchedule[] doctorSchedule = doctorDAO.getSchedule(request.getParameter("doctor"));
		request.setAttribute("schedule", doctorSchedule);
		request.getRequestDispatcher("/views/appointment/doctorSchedule.jsp").forward(request, response);
	}
	
	private void confirmDocAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] scheduleStrArr = request.getParameter("schedule").trim().split(" ");
		DoctorSchedule doctorSchedule = new DoctorSchedule();
		// TODO: also display details about the selected doctor
		
		doctorSchedule.setDoctorID(scheduleStrArr[0]);
		doctorSchedule.setDayOfWeek(scheduleStrArr[1]);
		doctorSchedule.setStartTime(scheduleStrArr[2]);
		doctorSchedule.setEndTime(scheduleStrArr[3]);
		
		request.setAttribute("schedule", doctorSchedule);
		request.getRequestDispatcher("/views/appointment/confirmDocAppointment.jsp").forward(request, response);
	}
	
	private void pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentDAO appointmentDAO = AppointmentDAO.getAppointmentDAO();
		DoctorSchedule doctorSchedule = new DoctorSchedule();
		
		doctorSchedule.setDayOfWeek(request.getParameter("doctorID"));
		doctorSchedule.setDoctorID(request.getParameter("dayOfWeek"));
		doctorSchedule.setStartTime(request.getParameter("startTime"));
		doctorSchedule.setEndTime(request.getParameter("endTime"));
		
		String date = request.getParameter("date");
		String time = request.getParameter("startTime");
		String date_time = date + " " + time;
		System.out.println(date_time); // debug line
		String remarks = request.getParameter("remarks");
		String doctorOrLabID = request.getParameter("doctorID");
		
		String appointmentID = appointmentDAO.insertDocAccpointmnet(date_time, remarks, doctorOrLabID);
		
		request.setAttribute("appointmentID", appointmentID);
		request.setAttribute("schedule", doctorSchedule);
		request.getRequestDispatcher("/views/appointment/confirmDocPayment.jsp").forward(request, response);
	}
	
	private void payConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentDAO appointmentDAO = AppointmentDAO.getAppointmentDAO();
		
		String method = request.getParameter("method");
		String appointmentID = request.getParameter("appointmentID");
		String paymentID = Pay.pay(method);
		
		appointmentDAO.setPaymentID(appointmentID, paymentID);
		
		request.getRequestDispatcher("/views/appointment/success.jsp").forward(request, response);
	}
	
	private void cancelAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentDAO appointmentDAO = AppointmentDAO.getAppointmentDAO();
		
		String appointmentID = request.getParameter("appointmentID");
		appointmentDAO.deleteAppointment(appointmentID);
		
		request.getRequestDispatcher("/views/appointment/cancelled.jsp").forward(request, response);
	}
	
	private void updateAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorSchedule doctorSchedule = new DoctorSchedule();
		String appointmentID = request.getParameter("appointmentID");
		
		doctorSchedule.setDoctorID(request.getParameter("doctorID"));
		doctorSchedule.setDayOfWeek(request.getParameter("dayOfWeek"));
		doctorSchedule.setStartTime(request.getParameter("startTime"));
		doctorSchedule.setEndTime(request.getParameter("endTime"));
		
		request.setAttribute("appointmentID", appointmentID);
		request.setAttribute("schedule", doctorSchedule);
		request.getRequestDispatcher("/views/appointment/updateAppointment.jsp").forward(request, response);
	}
	
	private void payUpdated(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentDAO appointmentDAO = AppointmentDAO.getAppointmentDAO();
		DoctorSchedule doctorSchedule = new DoctorSchedule();
		String appointmentID = request.getParameter("appointmentID");
		
		doctorSchedule.setDayOfWeek(request.getParameter("doctorID"));
		doctorSchedule.setDoctorID(request.getParameter("dayOfWeek"));
		doctorSchedule.setStartTime(request.getParameter("startTime"));
		doctorSchedule.setEndTime(request.getParameter("endTime"));
		
		String date = request.getParameter("date");
		String time = request.getParameter("startTime");
		String date_time = date + " " + time;
		System.out.println(date_time); // debug line
		String remarks = request.getParameter("remarks");
		String doctorOrLabID = request.getParameter("doctorID");
		
		appointmentDAO.updateAppointment(appointmentID, date_time, remarks);
		
		request.setAttribute("appointmentID", appointmentID);
		request.setAttribute("schedule", doctorSchedule);
		request.getRequestDispatcher("/views/appointment/confirmDocPayment.jsp").forward(request, response);
	}
}
