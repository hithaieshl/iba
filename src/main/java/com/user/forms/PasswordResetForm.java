package com.user.forms;

import org.hibernate.validator.constraints.NotEmpty;

public class PasswordResetForm {

	@NotEmpty
	private String password;
	
	@NotEmpty
	private String passwordRepeated;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}
	
	
}
