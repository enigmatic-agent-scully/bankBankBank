package com.aj;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = -7010359379959591260L;
	private long accountID;
	private boolean canceleled, isActivated, isJoint;
	private String name1, pw1, name2, pw2;
	private double checking, saving, credit;
	
	User(){};

	public User(String name1, String pw1, boolean isJoint, long accountID) {
		super();
		this.accountID = accountID;
		
		this.isActivated = false;
		this.isJoint = isJoint;
		this.name1 = name1;
		this.pw1 = pw1;
		this.name2 = "n/a";
		this.pw2 = "n/a";
		this.checking = 0d;
		this.saving = 0d;
		this.credit = 0d;
		boolean cancelled = false;
	}

	public User(String name1, String pw1, String name2, String pw2, boolean isJoint, long accountID) {
		super();
		this.accountID = accountID;
		this.isActivated = false;
		this.isJoint = isJoint;
		this.name1 = name1;
		this.pw1 = pw1;
		this.name2 = name2;
		this.pw2 = pw2;
		this.checking = 0d;
		this.saving = 0d;
		this.credit = 0d;
		boolean cancelled = false;
	}
	

	public long getAccountID() {
		return accountID;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public boolean isJoint() {
		return isJoint;
	}

	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	public double getChecking() {
		return checking;
	}

	public void setChecking(double checking) {
		this.checking = checking;
	}

	public double getSaving() {
		return saving;
	}

	public void setSaving(double saving) {
		this.saving = saving;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public boolean isCanceleled() {
		return canceleled;
	}

	public void setCanceleled(boolean canceleled) {
		this.canceleled = canceleled;
	}

	@Override
	public String toString() {
		return "User [accountID=" + accountID + ", canceleled=" + canceleled + ", isActivated=" + isActivated
				+ ", isJoint=" + isJoint + ", name1=" + name1 + ", pw1=" + pw1 + ", name2=" + name2 + ", pw2=" + pw2
				+ ", checking=" + checking + ", saving=" + saving + ", credit=" + credit + "]";
	}
	
	

	
	
	
	

	
	
	
	
	
	
	
	
}
