package com.aj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserEntrance {
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static final String filename = "Data.txt";
	int num;
	boolean flag, yesNoTemp;
	String temp1, temp2, temp3, temp4;

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

	public static String[] employeeLoginMenu() {

		String[] employeeCredentials = new String[2];
		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Please enter your password:");
		String pw = scan.nextLine();
		employeeCredentials[0] = username;
		employeeCredentials[1] = pw;

		return employeeCredentials;

	}

	public void employeeRregister() {

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

			createEmployeeAccount(temp1, temp2, yesNoTemp);
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
}
