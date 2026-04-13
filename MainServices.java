package com.linkcode.vehicleRentalSystem;

import java.util.Scanner;

public class MainServices {
	
	static Scanner sc=new Scanner(System.in);
	static VehicleInventory inventory=new VehicleInventory();
	private static boolean flag;
	
	public static void main(String[] args) {
		boolean flag=true;
		while(flag) {
		System.out.println("----Vehicle Rental System --------");
		System.out.println("1.Admin");
		System.out.println("2.Customer");
		System.out.println("Enter Your Choice ");
		int ch=sc.nextInt();
		switch(ch) {
		case 1-> showAdminMenu();
		case 2-> showCustomerMenu();
		default-> System.out.println("Invalid Choice");
		}
		}
		
	}
	


	public static void intializeVehicle() {
		inventory.addVehicle(new Car("c001",5000 ,7));
		inventory.addVehicle(new Car("c002",4000 ,5));
		inventory.addVehicle(new Bike("b001",500 ,true));
		inventory.addVehicle(new Bike("b002",400 ,false));
		inventory.addVehicle(new Bus("bs001",7000 ,25));
		inventory.addVehicle(new Bus("bs002",8000 ,30));
		
	}
	
	private static void showAdminMenu() {
		System.out.println("Enter Username :");
		String username=sc.next();
		System.out.println("Enter Password:");
		String pass=sc.next();
		
		boolean flag=true;
		while(flag) {
			
		
		
		if(Admin.authenticate(username,pass)){
		System.out.println("----Menu----");
		System.out.println("1.Add vehicle");
		System.out.println("2.remove vehicle");
		System.out.println("3.send vehicle for maintenance");
		System.out.println("4.Complete Vehicle Maintenance");
		System.out.println("5.show all vehicle info");		
		System.out.println("6.Exit");
		
		int ch=sc.nextInt();
		switch(ch) {
		case 1->{
			System.out.println("1.Car");
			System.out.println("2.Bus");
			System.out.println("3.Bike");
			System.out.println("Enter Choice:");
			int choice =sc.nextInt();
			System.out.println("Enter vehicle Id:");
			String id=sc.next();
			System.out.println("Enter Rental rate:");
			double rate=sc.nextDouble();
			switch(choice) {
			case 1->{
				System.out.println("Ente no of seats");
				int no=sc.nextInt();
				Car car=new Car(id,rate,no);
				inventory.addVehicle(car);
				System.out.println("Car added Successfully");
			}
			case 2 ->{
				System.out.println("Enter no of seats");
				int no=sc.nextInt();
				Bus bus=new Bus(id,rate,no);
				inventory.addVehicle(bus);
				System.out.println("bus Added Successfully");
			}
			case 3->{
				System.out.println("Helmet Available ? (yes/No):");
				String ha=sc.next();
				boolean hat=ha.equalsIgnoreCase("yes");
				inventory.addVehicle(new Bike(id, rate, hat));
				System.out.println("Bike added Successfully");
				
			}
			default -> System.out.println("Invalid choice!!!!!");
			}
		}
		case 2->{
			System.out.println("Enter Vehicle Id");
			String id=sc.next();
			Vehicle vehicle= FindVehicleById(id);
			if(vehicle!=null) {
				System.out.println("vehicle found");
				inventory.addVehicle(vehicle);
			}else {
				System.out.println("Vehicle not found");
			}
		}
		case 3->{
			System.out.println("Enter vehicle id");
			String id=sc.next();
		Vehicle vehicle=FindVehicleById(id);
		vehicle.sendForMaintenance();
		System.out.println("Vehicle marked for maintenance");
		}
		
//		case 2->
//		case 3->
//		case 4->
//		case 5->
		case 6-> flag =false;
		}
	}else{
		System.out.println("Invalid username or Password");
	}
	}
	}



	private static void showCustomerMenu() {
		return null;
		
	}
	
	public static void showCustomerMenu1() {
		boolean f=true;
		System.out.println("------Form------");
		System.out.println("Enter your name:");
		String name=sc.next();
		sc.nextLine();
		System.out.println("Enter your email");
		String email=sc.nextLine();
		System.out.println("Enter your mpbile number");
		long mobile=sc.nextLong();
		System.out.println("Liscense Available:(yes/no)");
		String la=sc.next();
		boolean ls=la.equalsIgnoreCase("yes");
		
		Customer customer= new Customer(name, mobile, email, ls);
		while(f) {
			System.out.println("---------Customer Menu---------");
			System.out.println("1.Show available cars");
			System.out.println("2.Show available bikes");
			System.out.println("Show avaiable Bus");
			System.out.println("Rent a vehicle");
			System.out.println("Return rented vehicle");
			System.out.println("View Rented vehicles");
			System.out.println("7.Exit");
			System.out.println("Enter your choice:");
			int ch=sc.nextInt();
			switch(ch) {
			case 1-> inventory.showAvailableVehicles(Car.class);
			case 2-> inventory.showAvailableVehicles(Bike.class);
			case 3-> inventory.showAvailableVehicles(Bus.class);
			case 7->f=false;
			default-> System.out.println("Invaild choice");
			}
			
		}

	

}
