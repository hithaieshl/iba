package com.iba.service;

import java.util.List;

import com.iba.domain.BankDetails;
import com.iba.domain.PersonalDetails;
import com.iba.domain.RegisteredEmail;
import com.iba.forms.AddEmailForm;
import com.iba.forms.BankDetailsForm;
import com.iba.forms.PersonalDetailsForm;

public interface IbaService {
	
	PersonalDetails savePersonalDetails(PersonalDetailsForm personalDetailsform);
	
	BankDetails saveBankDetails(BankDetailsForm bankDetailsForm);
	
	List<RegisteredEmail> getRegisteredEmail(String email);
	
	RegisteredEmail saveEmail(AddEmailForm addEmailForm);
	
	
	
	
}
