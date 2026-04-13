package com.linkcode.vehicleRentalSystem;

import java.util.ArrayList;

import java.util.List;

public class Customer {

	private String name ;
	private long mobile;
	private String email;
	private boolean isLicescneceAvailable;
	
	private ArrayList rentedVehicles;
	
	
	
	public Customer(String name, long mobile, String email, boolean la) {
		
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.isLicescneceAvailable = la;
		
		this.rentedVehicles =new ArrayList();
	}

	public void rentVehicle(Vehicle veh, int no) {
		if(veh.isAvailable()) {
			
			if(veh.rent(this, no)) {
				System.out.println("Process Complete!");
				this.rentedVehicles.add(veh);
				
			}else {
				System.out.println("Process Incomplete!");
			}
//			veh.rent(this,no);
			
		}else {
			System.out.println("Vehicle not present");
		}
		
	}
	
	public void returnVehicle() {
		
	}
	
	public void viewRentedVehicle() {
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}
