package com.aj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerEntrance {
	public static Scanner scan = new Scanner(System.in);

	CustomerEntrance() {
	};

	public void CustomerMenu1() {

		int num;
		do {

			System.out.println("\nWelcome to customer menu:\n");
			System.out.println("press 1 ~ to login");
			System.out.println("press 2 ~ to register");

			try {
				num = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException ex) {
				num = 3;
			} catch(InputMismatchException a) {
				a.printStackTrace();
				num = 3;
			}

			if (2 < num || num < 1) {
				num = 3;
			}

			switch (num) {
			case 1:
				System.out.println("customer.login();");
				// customer.login();
				num = 4;
				break;
			case 2:
				System.out.println("customer.register();");
				// customer.register();
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
			}
		} while (num == 1 || num == 2 || num == 3);

	}

}
