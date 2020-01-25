package com.aj;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankMainDriver {
	public static Scanner scan = new Scanner(System.in);
	public static Logger LOGGER = LogManager.getLogger(BankMainDriver.class);
	static int num;
	static boolean flag;
	static boolean yesNoTemp;
	String temp1, temp2, temp3, temp4;

	public static void main(String[] args) {
		LOGGER.info("message");
		
		
		
		do {
			flag = true;

			System.out.println("Welcome to use OnePiece bank service  \n\n");
			System.out.println("press 1 ~ for users");
			System.out.println("press 2 ~ for employees");
//			System.out.println("press 0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    Power off");

			try {
				num = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException ex) {
				num = 3;
			}

			if (2 < num || num < 1) {
				num = 3;
			}

			switch (num) {
			case 1:
				CustomerEntrance user1 = new CustomerEntrance();
				user1.CustomerMenu1();
				
				break;
			case 2:
				EmployeeEntrance employee1 = new EmployeeEntrance();
				employee1.EmployeeMenu();
				
				break;
			case 3:
				System.out.println("Please enter a valid number \n\n\n\n\n");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
//			default:
//				System.out.println("Please enter a valid number");
			}

		} while (flag);

	}

}
