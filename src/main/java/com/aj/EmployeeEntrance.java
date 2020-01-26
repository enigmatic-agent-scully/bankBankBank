package com.aj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeEntrance {
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static final String filename = "Data.txt";
	int num;
	boolean flag, yesNoTemp;
	static boolean isLoggedIn;
	public static Employee currentlyLoggedIn = null;

	EmployeeEntrance() {
	};

	@SuppressWarnings("unchecked")
	public void EmployeeMenu() {

		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object

			employees = (ArrayList<Employee>) in.readObject();
			users = (ArrayList<User>) in.readObject();

			in.close();
			file.close();

		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}

		// just a reference;
		for (Employee eachEmployee : employees) {
			System.out.println(eachEmployee);
		}

		do {
			flag = true;
			System.out.println("\n\n\nWelcome to the Employee menu:\n");
			System.out.println("press 1 ~ to login");
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
				employeeLoginMenu();
				break;
			case 2:
				// ~~~~~~~~~~~~~~~~~~ to employee.register
				try {
					employeeRregister();
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

	public static void employeeLoginMenu() {
		boolean usernameFound = false;
		isLoggedIn = false;

		System.out.println("Please enter your username:");
		String username = scan.nextLine();

		for (Employee e : employees) {
			if (e.getName().contentEquals(username)) {
				usernameFound = true;
			}
		}
		if (!usernameFound) {
			System.out.println("The username you entered does not match our records. Please try again.");
			username = scan.nextLine();
			for (Employee e : employees) {
				if (e.getName().contentEquals(username)) {
					usernameFound = true;
				}
			}
		}
		System.out.println("Please enter your password:");
		String pw = scan.nextLine();

		for (Employee e : employees) {
			if (e.getName().contentEquals(username) && e.getPw().contentEquals(pw)) {
				isLoggedIn = true;
				currentlyLoggedIn = e;
			}
			else {
				System.out.println("The password you entered is incorrect. Please enter your password:");
				pw = scan.nextLine();
			}
		}
		System.out.println("\nLogin successful!\nYou are currently logged in as " + currentlyLoggedIn.getName());

		displayEmployeeUI(currentlyLoggedIn.isAdmin());
	}

	public void employeeRregister() {
		String temp1, temp2, temp3, temp4;

		do {

			flag = true;

			System.out.println("enter name you want:");
			temp1 = scan.nextLine();
			System.out.println("enter password you want:");
			temp2 = scan.nextLine();
			System.out.println("please confirm your password:");
			temp3 = scan.nextLine();
			System.out.println();

			System.out.println("r u admin ?    (Y/N)");
			temp4 = scan.nextLine();

			if (temp4.toUpperCase().contentEquals("YES") || temp4.toUpperCase().contentEquals("Y")) {
				yesNoTemp = true;
			} else {
				yesNoTemp = false;
			}

			if (!temp2.contentEquals(temp3)) {
				System.out.println("your pass doesn't match~ ");
				continue;
			}

			if (checkUsable(temp1) == false) {
				System.out.println(temp1 + " is already in use.");
				continue;
			}

			createEmployeeAccount(temp1, temp2, yesNoTemp);
			System.out.println(" your account has been initialized");
			delayTime(5);
			flag = false;

		} while (flag);

	}

	private void createEmployeeAccount(String temp1, String temp2, boolean admin) {

		try {
			employees.add(new Employee(temp1, temp2, admin));

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

	public static void displayEmployeeUI(boolean isAdmin) {
		System.out.println("\nWelcome to the Employee Interface.\n\n");
		if (isAdmin) {
			System.out.println("Hello Admin.");
			for (User u : users) {
				System.out.println(u);
			}
		} else {
			for (User u : users) {
				if (u.isActivated()) {
					System.out.print("Account ID: " + u.getAccountID() + " | ");
					System.out.print("Primary Account Holder: " + u.getName1() + " | ");
					if (!u.getName2().contentEquals("n/a")) {
						System.out.print("Secondary Account Holder: " + u.getName2() + " | ");
					}
					System.out.println("Checking Account Balance: $" + u.getChecking() + " | ");
					System.out.println("Savings Account Balance: $" + u.getSaving());
				}
			}
		}
	}
	
	public void adminMenu() {
		
	}

	public boolean checkUsable(String username) {
		System.out.println("Checking if username is available");

		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getName().contentEquals(username)) {
				System.out.println(username + " has already been taken. Please choose another username.");
				return false;
			}
		}
		return true;
	}

	public void delayTime(int count) {

		for (int i = 0; i < count; i++) {

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
