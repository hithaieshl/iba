package com.user.forms;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRegisterForm {

	@NotEmpty
	private String email;
	
	@Max(1)
	private int role;

	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
