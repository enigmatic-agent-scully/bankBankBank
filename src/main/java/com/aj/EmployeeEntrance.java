package com.aj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeEntrance {
	public static Scanner scan = new Scanner(System.in);

	EmployeeEntrance(){};
	
public void EmployeeMenu () {
	
	int num;
	do {
		
		System.out.println("\n\n\nWelcome to Employee menu:\n");
		System.out.println("press 1 ~ if you are a Bank Admin");
		System.out.println("press 2 ~ if you are a Bank Employee");
		
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
			System.out.println("admin.loginMenu();");
			//admin.loginMenu();
			num = 4;
			break;
		case 2:
			System.out.println("employee.loginMenu();");
			//employee.loginMenu();
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
	} while ( num==1 || num==2 || num ==3);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
}
