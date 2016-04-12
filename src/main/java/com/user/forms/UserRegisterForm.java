package com.user.forms;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRegisterForm {

	@NotEmpty
	private String email;
	
	@NotEmpty
	private String role;

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
