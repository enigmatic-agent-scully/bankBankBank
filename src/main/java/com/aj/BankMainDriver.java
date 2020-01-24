package com.aj;

import java.util.Scanner;

public class BankMainDriver {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		int num;
		do {
			
			
			System.out.println("Welcome to use OnePiece bank service  \n\n");
			System.out.println("press 1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    for user");
			System.out.println("press 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    for employee");
			System.out.println("press 3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    if you are lost");
			num = scan.nextInt();
			
			
			switch (num) {
			case 1:
				UserEnterance user1 = new UserEnterance();
				user1.UserMenu1();
				break;
			case 2:
				EmployeeEnterance employee1 = new EmployeeEnterance();
				employee1.EmployeeMenu();
				break;
			case 3:
				System.out.println("shut up");
				break;
			default:
				System.out.println("bye bye");

			}
		} while ( num==1 || num==2 || num ==3);
		
		
		
		
		
	}
		

		
	

}
