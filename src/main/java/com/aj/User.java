package com.aj;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long acctID;
	
	private boolean activated, isJoint;
	
	private String userName1, pw1, userName2, pw2;
	

	
	public User(String userName1, String pw1, String userName2, String pw2) throws Throwable {
		//UserHelper uh = new UserHelper();
		this.userName1 = userName1;
		this.pw1 = pw1;
		this.userName2 = userName2;
		this.pw2 = pw2;
		this.activated = false;
		this.isJoint = true;
		//this.acctID = uh.getNewID();
	}
	
	public User(String userName1, String pw1) throws Throwable {
		//UserHelper uh = new UserHelper();
		this.userName1 = userName1;
		this.pw1 = pw1;
		this.userName2 = "N/A";  
		this.pw2 = "N/A";  
		this.activated = false;
		this.isJoint = false;
	//	this.acctID = uh.getNewID();
	}

	public long getUserID() {
		return acctID;
	}

	public void setAcctID(long acctID) {
		this.acctID = acctID;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}

	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	@Override
	public String toString() {
		return "User [acctID=" + acctID + ", activated=" + activated + ", userName1=" + userName1 + ", pw1=" + pw1
				+ ", userName2=" + userName2 + ", pw2=" + pw2 + "]";
	}

	public boolean isJoint() {
		return isJoint;
	}

	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}
	
	
}
