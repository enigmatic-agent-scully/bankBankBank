package com.aj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerEntrance {
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static final String filename = "Data.txt";
	boolean flag, yesNoTemp;
	int num;
	String temp1, temp2, temp3, temp4;

	CustomerEntrance() {
	};

	@SuppressWarnings("unchecked")
	public void CustomerMenu1() {

		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			users = (ArrayList<User>) in.readObject();
			// employees = (ArrayList<Employee>) in.readObject();

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
		
		for (User u : users) {
			System.out.println(u);
		}

		do {
			flag = true;
			System.out.println("\nWelcome to customer menu:\n");
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
				customerRegister();
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
			case 0:
				flag = false;
				break;
			}
		} while (flag);

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

	public void customerRegister() {

		do {

			flag = true;

			System.out.println("enter name you want:");
			temp1 = scan.nextLine();
			System.out.println("enter password you want:");
			temp2 = scan.nextLine();
			System.out.println("please confirm your password:");
			temp3 = scan.nextLine();
			System.out.println();

			if (!temp2.contentEquals(temp3)) {
				System.out.println("your pass doesn't match~ ");
				continue;
			}

			createCustomerAccount(temp1, temp2);
			flag = false;

		} while (flag);

	}

	private void createCustomerAccount(String temp1, String temp2) {

		try {
			users.add(new User(temp1, temp2));

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(users);
			out.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

}
