package com.user.service;

import org.springframework.stereotype.Service;

import com.user.forms.UserRegisterForm;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{

	@Override
	public void saveUser(UserRegisterForm userRegisterform) {
		userRegisterform.getEmail();
	}

	
}
