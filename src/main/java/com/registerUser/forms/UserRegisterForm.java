package com.registerUser.forms;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRegisterForm {

	@NotEmpty
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
