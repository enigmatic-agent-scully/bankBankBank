package com.aj;

import java.util.Scanner;

public class EmployeeEnterance {
	public static Scanner scan = new Scanner(System.in);

	EmployeeEnterance(){};
	
public void EmployeeMenu () {
	
	int num;
	do {
		
		
		System.out.println("Welcome to user menu  \n\n");
		System.out.println("press 1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    ");
		System.out.println("press 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    ");
		System.out.println("press 3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    ");
		num = scan.nextInt();
		
		
		switch (num) {
		case 1:
			System.out.println("haha  I am  employee");
			break;
		case 2:
			System.out.println("haha2");
			break;
		case 3:
			System.out.println();
			break;
		default:
			System.out.println("bye bye");

		}
	} while ( num==1 || num==2 || num ==3);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
}
