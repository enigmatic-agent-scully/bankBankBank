package com.aj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
class Account implements Serializable {
	@SuppressWarnings("unused")
	private static final long serialversionUID = 129348938L;
	int a;
	int b;
	String name;
	int age;

	Account() {
	};

	// Default constructor
	public Account(String name, int age, int a, int b) {
		this.name = name;
		this.age = age;
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", a=" + a + ", b = " + b + " ]";
	}

}

public class SerialExample {
	public static void printdata(Account object1) {

		System.out.println("name = " + object1.name);
		System.out.println("age = " + object1.age);
		System.out.println("a = " + object1.a);
		System.out.println("b = " + object1.b);
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<Account> al = new ArrayList<Account>();
		al.add(new Account("jinjun zhen", 32, 8, 10));
		al.add(new Account("xiao pengyou", 32, 8, 10));
		al.add(new Account("xiao ming", 32, 8, 10));
		al.add(new Account("da ming", 32, 8, 10));
		al.add(new Account("xiao huoji", 32, 8, 10));
		al.add(new Account("xiao qingting", 32, 8, 10));

		// String filename = "/Users/jinjunzhen/desktop/BankExcel.txt";
		String filename = "C:\\Users\\AJ\\code\\revature\\aj_workspace\\WriteToPositionTest\\temp.ser";
		// Serialization
		try {

			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(al);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n" + "Data before Deserialization.");

			// value of static variable changed
			// object.b = 1000;
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		// Deserialization
		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			al = (ArrayList<Account>) in.readObject();

			in.close();
			file.close();
			System.out.println("Object has been deserialized\n" + "Data after Deserialization.");

			// System.out.println("z = " + object1.z);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}

		for (Account eachAcct : al) {
			System.out.println(eachAcct);
		}

	}
}
