package com.iba.service;

import com.iba.domain.BankDetails;
import com.iba.domain.PersonalDetails;
import com.iba.forms.BankDetailsForm;
import com.iba.forms.PersonalDetailsForm;

public interface IbaService {
	
	PersonalDetails savePersonalDetails(PersonalDetailsForm personalDetailsform);
	
	BankDetails saveBankDetails(BankDetailsForm bankDetailsForm);
			
}
