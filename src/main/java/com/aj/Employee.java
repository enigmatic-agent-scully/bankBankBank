package com.aj;

import java.io.Serializable;

public class Employee implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7010359379959591260L;
	
	private String name, pw;
	private boolean isAdmin;


	public Employee(String temp1, String temp2, boolean admin) {
		this.name = temp1;
		this.pw = temp2;
		this.isAdmin = admin;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public String getName() {
		return name;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}



	@Override
	public String toString() {
		return "Employee [name=" + name + ", pw=" + pw + ", isAdmin=" + isAdmin + "]";
	}


	

}
