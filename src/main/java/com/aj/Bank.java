package com.aj;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	static Scanner input = new Scanner(System.in);
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	
	
	public Bank() {
		
	}
	
	public static void menu() {
		System.out.println("Welcome. If you are a customer, please press 1. If you are an employee, please press 2.");
		int answer = input.nextInt();
		switch (answer) {
		case 1: 
			//customerMenu();
			break;
		case 2: 
			//employeeMenu();
			break;
		}
	}
	
	public static void logIn() {
		System.out.println("Please enter your username:");
		String username = input.next();
		System.out.println("Please enter your password:");
		String pw = input.next();
		
	}
	
	public static void register() {
		System.out.println();
	}
	
	public static void customerMenu() {
		System.out.println();
	}
}
