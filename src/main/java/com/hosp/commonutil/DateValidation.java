package com.hosp.commonutil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;



//expiry
public class DateValidation{
	public static void amin(String args[]) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		//System.out.println("" + expDate); //debug
		System.out.println("" + date); //debug
		
		Date expDate = sdf.parse("2022-05-09");
		String dateToStr = new String(); //String dateToStr = dateFormat.format(date);
		
		if(expDate.after(date)) {
			
		}
		else {
			System.out.println("Invalid Expiry Date");
		}
	}
}
