package com.hosp.commonutil;

public class EditID {
	public static String incrementID(String id) throws InvalidIDException, NumberFormatException {
		if (id.length() > 5 || id.length() == 0) {
			throw new InvalidIDException("Length " + id.length() + " is invalid for a database ID");
		}
		
		String newid;
		int num = Integer.parseInt(id.substring(2)) + 1;
		
		if (num < 0) {
			throw new InvalidIDException("Numeric part of ID cannot be negative");
		} else if (num < 10) {
			newid = id.substring(0, 2) + "00" + num;
		} else if (num < 100) {
			newid = id.substring(0, 2) + "0" + num;
		} else {
			newid = id.substring(0, 2) + num;
		}
		
		return newid;
	}
}
