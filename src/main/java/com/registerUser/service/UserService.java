package com.registerUser.service;

import java.util.Collection;

import com.registerUser.forms.UserCreateForm;
import com.domain.User;

public interface UserService 
{
	User getUserById(long id);

    User getUserByEmail(String email);
    
    User getUserByUserName(String username);

    Collection <User> getAllUsers();
    
    User create(UserCreateForm form);
}