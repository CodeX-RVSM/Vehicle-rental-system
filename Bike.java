package com.linkcode.vehicleRentalSystem;

public class Bike extends Vehicle {
	
	private boolean helmetAvailable;
	
	Bike(String id,double rate,boolean ha){
		super(id,rate);
		this.helmetAvailable=ha;
	}
	
	public void displayInfo() {
		
	}

}
