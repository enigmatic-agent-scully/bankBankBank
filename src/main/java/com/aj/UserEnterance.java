package com.aj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserEnterance {
	public static Scanner scan = new Scanner(System.in);

	UserEnterance() {
	};

	public void UserMenu1() {

		int num;
		do {

			System.out.println("Welcome to user menu  \n\n");
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
				System.out.println("Login function goes here");
				// user.login();
				break;
			case 2:
				System.out.println("Register function goes here");
				// user.register();
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
