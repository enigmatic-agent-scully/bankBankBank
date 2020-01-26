package com.aj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class UserEntrance {
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static final String filename = "Data.txt";
	int num;
	boolean flag, yesNoTemp;
	

	UserEntrance() {
	};

	public void userMenu() {


		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object

			employees = (ArrayList<Employee>) in.readObject();
			users = (ArrayList<User>) in.readObject();
			

			in.close();
			file.close();
			// System.out.println("Object has been deserialized\n" + "Data after
			// Deserialization.");

		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}

		// just a reference;
		for (User eachUser : users) {
			System.out.println(eachUser);
		}


		do {
			flag = true;
			System.out.println("\n\n\nWelcome to the User menu:\n");
			System.out.println("press 1 ~ to log in");
			System.out.println("press 2 ~ to register");
			System.out.println("press 0 ~ get back to main page");

			try {
				num = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException ex) {
				num = 3;
			} catch (InputMismatchException a) {
				a.printStackTrace();
				num = 3;
			}

			if (2 < num || num < 0) {
				num = 3;
			}

			switch (num) {

			case 1:
				userLoginMenu();
				break;
			case 2:
				// ~~~~~~~~~~~~~~~~~~ to employee.register
				try {
					userRregister();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;
			case 3:
				System.out.println("Please choose a valid number \n\n\n\n\n");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 0:
				flag = false;
				break;

			}
		} while (flag);
	}

	public static void userLoginMenu() {
		String temp1, temp2;
		
		System.out.println(" log in with user name and pass word ");
		System.out.println("user name:");
		temp1 = scan.nextLine();
		System.out.println("pass word:");
		temp1 = scan.nextLine();
		

	}

	
	public void userRregister() {
		
		String name1, pw1, pw1confirm, name2, pw2, pw2confirm, singJoint;

		do {

			flag = true;


			System.out.println("[S]ingle account or [J]oint account?    (S/J)");
			singJoint = scan.nextLine();
			System.out.println();
			if (singJoint.toUpperCase().contentEquals("J") || singJoint.toUpperCase().contentEquals("JOINT")) {
				yesNoTemp = true;
			} else {
				yesNoTemp = false;
			}


			if (yesNoTemp) {

				System.out.println("enter user1 login name:");
				name1 = scan.nextLine();
				System.out.println("enter user1 password you want:");
				pw1 = scan.nextLine();
				System.out.println("please confirm your password:");
				pw1confirm = scan.nextLine();

				System.out.println("enter user2 login name:");
				name2 = scan.nextLine();
				System.out.println("enter user2 password you want:");
				pw2 = scan.nextLine();
				System.out.println("please confirm your password:");
				pw2confirm = scan.nextLine();

				if ( !pw1.contentEquals(pw1confirm) ||  !pw2.contentEquals(pw2confirm) ) {
					System.out.println("your pass doesn't match~ \n\n\n\n");
					continue;
				}
				if (checkUseable(name1) == false ||  checkUseable(name2) == false) {
					System.out.println("user name already exist");
					continue;
				}


				createUserAccount(name1, pw1, name2, pw2, true);
				System.out.println(" your account has been initialized");
				delayTime(5);
				flag = false;
			} else {

				System.out.println("enter user1 login name:");
				name1 = scan.nextLine();
				System.out.println("enter password you want:");
				pw1 = scan.nextLine();
				System.out.println("please confirm your password:");
				pw1confirm = scan.nextLine();

				if (!pw1.contentEquals(pw1confirm)) {
					System.out.println("your pass doesn't match~ ");
					continue;
				}
				
				if (checkUseable(name1) == false) {
					System.out.println("user name already exist");
					continue;
				}
				createUserAccount(name1, pw1, "n/a", "n/a", false);
				System.out.println(" your account has been initialized");
				delayTime(5);
				flag = false;
			}
		} while (flag);

	}

	private void createUserAccount(String name1, String ps1, String name2, String pw2, boolean isJoint ) {

		try {
			users.add(new User(name1, ps1, name2, pw2, isJoint, users.size()+1));

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
	
	
	
	public boolean checkUseable(String userName) {
		System.out.println("check in useable");
		
		for (int i = 0; i< users.size(); i++) {
			
			if (users.get(i).getName1().contentEquals(userName) || users.get(i).getName2().contentEquals(userName)) {
				System.out.println(userName + "alrady been taken");
				
				return false;
			}
			
		}
		return true;
	}


	public void delayTime(int count) {	

		for (int i=0; i<count; i++) {

			try {
				Thread.sleep(500);
				System.out.print(" .");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println();
	}
}

