package com.aj;

public class Customer extends User {
	private String fName, lName;
	private BankAccount account1;
	private BankAccount account2;
	
	public BankAccount getAccount1() {
		return account1;
	}
	public void setAccount1(BankAccount account1) {
		this.account1 = account1;
	}
	public BankAccount getAccount2() {
		return account2;
	}
	public void setAccount2(BankAccount account2) {
		this.account2 = account2;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
}
