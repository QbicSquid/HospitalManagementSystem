package com.hosp.commonutil;

import com.hosp.dbutil.PaymentDAO;
import com.hosp.payportal.PayPortal;

public class Pay {
	public static String pay(String method) {
		String recieptID = PayPortal.pay();
		PaymentDAO paymentDAO = new PaymentDAO();
		String paymentID = paymentDAO.insertPayment(recieptID, method);
		return paymentID;
	}
}
