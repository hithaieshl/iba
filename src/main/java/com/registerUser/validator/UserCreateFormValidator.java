package com.registerUser.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.registerUser.forms.UserCreateForm;
import com.registerUser.service.UserService;

@Component
public class UserCreateFormValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateFormValidator.class);

    private final UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
        validateUserName(errors, form);
    }

    private void validateUserName(Errors errors, UserCreateForm form) {
    	 if (userService.getUserByUserName(form.getUsername()) != null) {
         	errors.reject("username.exists", "User with this username already exists");
         }
	}

	private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, UserCreateForm form) {
        if (userService.getUserByEmail(form.getEmail()) != null) {
        	errors.reject("email.exists", "User with this email already exists");
        }
    }
}