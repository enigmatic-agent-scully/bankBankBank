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
		
		do {
			flag = true;
			
			System.out.println("Enter the accountID you want to transfer to ");
			try {
				accountID = Long.parseLong(scan.nextLine());
			} catch (NumberFormatException ex) {
				accountID = -1;
			}
			
			checkAccountID(accountID);
			
			
			
			
			
			
		} while(flag);
		

	}
	
public static boolean checkAccountID(long accountID) {
	
	for (int i=0; i< users.size(); i++) {
		if (users.get(i).getAccountID() == accountID) {
			return true;
		}
	}
	return false;
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
