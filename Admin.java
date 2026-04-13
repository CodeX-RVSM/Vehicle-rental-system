package com.linkcode.vehicleRentalSystem;

public class Admin {

	final private static String username="admin";
	final private static String password="admin@123";
	
	public static boolean authenticate(String user, String pass) {
		
		if(username.equals(user)&&password.equals(pass)) {
			return true;
		}
		
		return false;
	}
}
