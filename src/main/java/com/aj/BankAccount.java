package com.aj;

public class BankAccount {
	private int accNum, balance1, balance2;

	public BankAccount() {
	}

	public BankAccount(int accNum) {
		this.accNum = accNum;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int custId) {
		this.accNum = accNum;
	}

	public int getBalance1() {
		return balance1;
	}

	public void setBalance1(int balance1) {
		this.balance1 = balance1;
	}

	public int getBalance2() {
		return balance2;
	}

	public void setBalance2(int balance2) {
		this.balance2 = balance2;
	}
}
