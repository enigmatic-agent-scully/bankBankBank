package com.aj;

public class User {
	private String username, pw, id;
	
	public User() {}
	
	public User(String username, String pw, String id) {
		this.username = username;
		this.pw = pw;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}