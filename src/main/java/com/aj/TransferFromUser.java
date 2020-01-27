package com.aj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TransferFromUser {

	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static final String filename = "Data.txt";
	static long accountID;
	static int num;
	static boolean flag, yesNoTemp;

	public void transferMenu(int accountIndex) {
		toLoad();
		int targetIndex;
		String singJoint;


		do {
			targetIndex = -1;
			flag = true;

			System.out.println("Enter the accountID you want to transfer to ");
			try {
				accountID = Long.parseLong(scan.nextLine());
			} catch (NumberFormatException ex) {
				accountID = -1;
			}

			targetIndex = checkAccountID(accountID);
			
			if (targetIndex == -1) {
				System.out.println(" account not found ");
				flag = false;
			} else {
				System.out.println("do u want to transfer money to " + users.get(targetIndex).getName1() + "? (Y/N");
				
				try {
					singJoint = scan.nextLine().toUpperCase();
				} catch (NumberFormatException ex) {
					singJoint = "no";
				}
				
				if (singJoint.contentEquals("Y") || singJoint.contentEquals("YES")) {
					yesNoTemp = true;
					flag = false;
					
				} else {
					yesNoTemp = false;
					flag = true;
					return;
				}
			}
			
			System.out.println("how much u want to tansfer? ");
			
			double money;
			
			try {
				money = Double.parseDouble(scan.nextLine());
				System.out.println("money is "+ money);
			} catch (NumberFormatException ex) {
				money = 0;
			}
			if (money < 0) {
				money = 0;
			}
			
			
			double balance;
			balance = users.get(accountIndex).getChecking();
			balance -= money;
			users.get(accountIndex).setChecking(balance);
			balance = users.get(targetIndex).getChecking();
			balance += money;
			users.get(targetIndex).setChecking(balance);
			toSave();
			
		} while(flag);

	}

	public static int checkAccountID(long accountID) {

		for (int i=0; i< users.size(); i++) {
			if ( (users.get(i).getAccountID() == accountID) && (users.get(i).isCanceleled()==false) ) {
				return i;
			}
		}
		return -1;
	}

	
	
	
	
	
	
	public static void toLoad() {

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
	}

	public static void toSave(){

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
