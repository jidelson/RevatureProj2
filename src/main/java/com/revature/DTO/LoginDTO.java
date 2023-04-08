package com.revature.DTO;

public class LoginDTO {

	public String username;
	public String password;
	
	
	
	
	
	//no-args constructor
	public LoginDTO() {
		super();
		
	}

	//all-args constructor
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	//getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
