package com.iba.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iba.forms.AddEmailForm;
import com.iba.service.IbaService;

@Component
public class AddEmailValidator implements Validator {
	
	private final IbaService ibaService;
	
	@Autowired
	public AddEmailValidator(IbaService ibaService) {
		this.ibaService = ibaService;
	}

    public boolean supports(Class<?> clazz) {
        return clazz.equals(AddEmailForm.class);
    }

	@Override
	public void validate(Object target, Errors errors) {
		AddEmailForm addEmailForm = (AddEmailForm) target;
		validateEmail(addEmailForm, errors);
	}

	public void validateEmail(AddEmailForm addEmailForm, Errors errors) {
		if(!ibaService.getRegisteredEmail(addEmailForm.getEmail()).isEmpty()){
			errors.reject("email", "User with this email already exists");
		}
	}

}
