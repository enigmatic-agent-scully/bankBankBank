package com.aj;

import java.util.Scanner;

public class UserEnterance {
	public static Scanner scan = new Scanner(System.in);
	
	UserEnterance() {};
	
	public void UserMenu1 () {
		
		int num;
		do {
			
			
			System.out.println("Welcome to user menu  \n\n");
			System.out.println("press 1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    ");
			System.out.println("press 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    ");
			System.out.println("press 3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    ");
			num = scan.nextInt();
			
			
			switch (num) {
			case 1:
				System.out.println("haha1");
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
