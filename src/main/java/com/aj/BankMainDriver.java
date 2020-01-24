package com.aj;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankMainDriver {
	public static Scanner scan = new Scanner(System.in);
	public static Logger LOGGER = LogManager.getLogger(BankMainDriver.class);

	public static void main(String[] args) {
		LOGGER.info("message");
		int num;
		do {

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
				num = 4;
				break;
			case 2:
				EmployeeEntrance employee1 = new EmployeeEntrance();
				employee1.EmployeeMenu();
				num = 4;
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

		} while (num == 1 || num == 2 || num == 3);

	}

}
