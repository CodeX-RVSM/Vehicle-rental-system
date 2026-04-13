package com.linkcode.vehicleRentalSystem;

public class Car extends Vehicle{
	
	private int noOfSeats;
	
	Car(String id,double rate,int no){
		super(id,rate);
		this.noOfSeats=no;
	}
	
	public void displayInfo() {
		
	}

}
