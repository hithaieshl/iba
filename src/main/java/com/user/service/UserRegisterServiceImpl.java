package com.user.service;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.domain.User;
import com.domain.UserRepository;
import com.user.forms.UserRegisterForm;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{

	UserRepository userRepository;
	
	@Autowired
	public UserRegisterServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void saveUser(UserRegisterForm userRegisterform) {
		User user = new User();
		String salt = "$2a$10$JiEiFYFtoN1t8Nl2XumQSe";
		String email = userRegisterform.getEmail();
		String rand = RandomStringUtils.random(10, true, true);
		String password = BCrypt.hashpw(rand, salt);
		String userName = email.substring(0, email.indexOf('@'));
		int role = userRegisterform.getRole();
		
		user.setEmail(email);
		user.setPassword(password);
		user.setUserName(userName);
		user.setRole(role);

		userRepository.save(user);
	}

}
