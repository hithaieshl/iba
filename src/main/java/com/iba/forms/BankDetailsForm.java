package com.iba.forms;

import org.hibernate.validator.constraints.NotEmpty;

public class BankDetailsForm {
	
	@NotEmpty
	private String bankName;
	
	@NotEmpty
	private String bankBranch;
	
	@NotEmpty
	private String accountHolderName;
	
	@NotEmpty
	private String accountNumber;

	@NotEmpty
	private String ifscCode;

	
	// SETTERS AND GETTERS
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
}
