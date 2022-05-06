package com.hosp.payportal;

import java.util.Random;

public class PayPortal {
	public static String pay() {
		Random r = new Random();
		String recieptId = Long.toString(System.currentTimeMillis()) +
										 Integer.toString(Math.abs(r.nextInt()));
		
		return recieptId;
	}
}
