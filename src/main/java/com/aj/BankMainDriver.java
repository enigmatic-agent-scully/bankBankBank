package com.aj;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankMainDriver {
	public static Scanner scan = new Scanner(System.in);
	private static final String filename = "Data.txt";
	public static Logger LOGGER = LogManager.getLogger(BankMainDriver.class);
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	static int num;
	static boolean flag;
	static boolean yesNoTemp;
	String temp1, temp2, temp3, temp4;

	public static void main(String[] args) {
		LOGGER.info("message");
		
		
		initializeDefault(false);

		
		do {
			flag = true;

			System.out.println("Welcome to use OnePiece bank service  \n\n");
			System.out.println("press 1 ~ for users");
			System.out.println("press 2 ~ for employees");
//			System.out.println("press 0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    Power off");

			try {
				num = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException ex) {
				num = 3;
			}

			if (2 < num || num < 1) {
				num = 3;
			}

			switch (num) {
			case 1:
				UserEntrance user = new UserEntrance();
				user.userMenu();
				
				break;
			case 2:
				EmployeeEntrance employee1 = new EmployeeEntrance();
				employee1.EmployeeMenu();
				
				break;
			case 3:
				System.out.println("Please enter a valid number \n\n\n\n\n");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
//			default:
//				System.out.println("Please enter a valid number");
			}

		} while (flag);

	}
	
	public static void initializeDefault(boolean resetDefaultDate) {
		
		
		if (resetDefaultDate == false)
			return;
		
		try {
			employees.add(new Employee("admin", "password", true));
			employees.add(new Employee("normal", "password", false));
			users.add( new User("user1 Not-activated", "password","joint man","password2 ", true, 1));
			User user2 = new User("user activated", "password","joint man","password2 ", false,  2);
			user2.setActivated(true);
			users.add( user2 );
			


		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {

			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(employees);
			out.writeObject(users);

			out.close();
			file.close();

			// if create successful jump back to employee menu

		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

}
