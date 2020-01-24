package com.aj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeEntrance {
	public static Scanner scan = new Scanner(System.in);

	EmployeeEntrance() {
	};

	public void EmployeeMenu() {

		int num;
		do {

			System.out.println("\n\n\nWelcome to the Employee menu:\n");
			System.out.println("press 1 ~ to login");
			System.out.println("press 2 ~ to register");

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
				employeeLoginMenu();
				num = 4;
				break;
			case 2:
				System.out.println("employee.register();");
				// employee.register();
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

	public static String[] employeeLoginMenu() {

		String[] employeeCredentials = new String[2];
		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Please enter your password:");
		String pw = scan.nextLine();
		employeeCredentials[0] = username;
		employeeCredentials[1] = pw;

		return employeeCredentials;

	}
	@SuppressWarnings("unused")
	public static String[] employeeRegisterMenu() {
		//call file contents
		
		String[] employeeRegisterInfo = new String[3];
		System.out.println("Please enter your desired username:");
		String username = scan.nextLine();
		String pw = "";
		String pwConfirm = "";
		//check if username exists
		// 	if(fileContents.contains(username) {
		//		System.out.println("This username is not available. Please choose another username.");
		//		}
		//	else {
		//		employeeRegisterInfo[0] = username;
		//		System.out.println("Please enter your desired password:");
		//		pw = scan.nextLine();
		//		
		//		System.out.println("Please confirm the password you entered:");
		//		pwConfirm = scan.nextLine();
		//		
		//		if (pw == pwConfirm) {
		//			employeeRegisterInfo[1] = pw;
		//			}
		//		}		
		return employeeRegisterInfo;
	}

}
