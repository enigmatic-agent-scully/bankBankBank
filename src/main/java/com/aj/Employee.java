package com.aj;

public class Employee {
	
	private long EmployeeID;
	
	private boolean isAdmin;
	
	private String name, pw;
	
	
	Employee(String name, String pw, boolean isAdmin) throws Throwable {
		EmployeeHelper eh = new EmployeeHelper();
		this.name = name;
		this.pw = pw;
		this.EmployeeID = eh.getNewID();
	}
	
	
	public long getEmployeeID () {
		
		return EmployeeID;
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


	public void setEmployeeID(long employeeID) {
		EmployeeID = employeeID;
	}
	
	
	

}
