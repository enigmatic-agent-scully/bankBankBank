package com.aj;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CustomerEntrance {
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static final String filename = "Data.txt";
	

	CustomerEntrance() {
	};

	public void CustomerMenu1() {
		
		
		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			users = (ArrayList<User>) in.readObject();
			employees = (ArrayList<Employee>) in.readObject();

			in.close();
			file.close();
			//System.out.println("Object has been deserialized\n" + "Data after Deserialization.");

			
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}
		
		
		
		
		

		int num;
		do {

			System.out.println("\nWelcome to customer menu:\n");
			System.out.println("press 1 ~ to login");
			System.out.println("press 2 ~ to register");

			try {
				num = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException ex) {
				num = 3;
			} catch(InputMismatchException a) {
				a.printStackTrace();
				num = 3;
			}

			if (2 < num || num < 1) {
				num = 3;
			}

			switch (num) {
			case 1:
				System.out.println("customer.login();");
				customerLoginMenu();
				num = 4;
				break;
			case 2:
				System.out.println("customerRegisterMenu();");
				customerRegisterMenu();
				num = 4;
				break;
			case 3:
				System.out.println("Please choose a valid number \n\n\n\n\n");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			}
		} while (num == 1 || num == 2 || num == 3);

	}
	
	public static String[] customerLoginMenu() {
		
		String[] custCredentials = new String[2];
		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Please enter your password:");
		String pw = scan.nextLine();
		custCredentials[0] = username;
		custCredentials[1] = pw;
		
		return custCredentials;
		
	}
	@SuppressWarnings("unused")
	public static String[] customerRegisterMenu() {
		//call file contents
		
		String[] customerRegisterInfo = new String[3];
		System.out.println("Please enter your desired username:");

		String username = scan.nextLine();
		String pw = "";
		String pwConfirm = "";
		//check if username exists
		// 	if(fileContents.contains(username) {
		//		System.out.println("This username is not available. Please choose another username.");
		//		}
		//	else {
		//		customerRegisterInfo[0] = username;
		//		System.out.println("Please enter your desired password:");
		//		pw = scan.nextLine();
		//		
		//		System.out.println("Please confirm the password you entered:");
		//		pwConfirm = scan.nextLine();
		//		
		//		if (pw == pwConfirm) {
		//			customerRegisterInfo[1] = pw;
		//			}
		//		}		
		return customerRegisterInfo;
	}

}
