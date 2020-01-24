package com.aj;

import java.util.Scanner;

public class EmployeeEnterance {
	public static Scanner scan = new Scanner(System.in);

	EmployeeEnterance(){};
	
public void EmployeeMenu () {
	
	int num;
	do {
		
		System.out.println("\n\n\nWelcome to Employee menu  \n\n");
		System.out.println("press 1 ~ to login");
		System.out.println("press 2 ~ to register");

		num = scan.nextInt();
		
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
			System.out.println("Emplpoyee login function");
			//employee.login();
			break;
		case 2:
			System.out.println("Employee register function");
			//employee.register();
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
	} while ( num==1 || num==2 || num ==3);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
}
