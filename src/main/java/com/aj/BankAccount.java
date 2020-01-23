package com.aj;

public class BankAccount {
	private int custId, balance1, balance2;

	public BankAccount() {
	}

	public BankAccount(int custId) {
		this.custId = custId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
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
