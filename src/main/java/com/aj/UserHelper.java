package com.aj;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class UserHelper {
	String filename = "Data.txt";
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	
	public long getNewID( ) throws Throwable {
		
		boolean isUnique;
		long newID;
	
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			
			users = (ArrayList<User>) in.readObject();
			employees = (ArrayList<Employee>) in.readObject();

			in.close();
			file.close();

		}
		catch (IOException ex) {
			
			System.out.println("IOException is caught");
		}
		
		do {
			isUnique = true;
			double x = Math.random();
			newID= (long)(x*100000000);     //here newID generated 
			
			
			for (User eachOne : users) {
				if (eachOne.getUserID() == newID) {
					isUnique = false;
				}
			}
			
		} while (isUnique);
		
		return newID;
	}
	
	public long depositByID( ) throws Throwable {
		long lo = 20;

		return lo;
	}
	
	public long withdrawByID( ) throws Throwable {
		long lo = 20;

		return lo;
	}
	
	public boolean checkNameUseable() throws Throwable {
		
		return true;
	}
	

}
