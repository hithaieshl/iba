package com.createUser.service;

import java.util.Collection;

import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.createUser.domain.UserCreateForm;
import com.domain.User;
import com.domain.UserRepository;
import com.domain.UserRole;
import com.domain.UserRolesRepository;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserRolesRepository userRoleRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRoleRepo = userRolesRepository;
    }

    @Override
    public User create(UserCreateForm form) {
    	LOGGER.info("*********************************************create");

        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setUserName(form.getUsername());
        userRepository.save(user);
        
        UserRole userRole = new UserRole();
        userRole.setRole(form.getRole());
        userRole.setUserid(user.getUserid());
        userRoleRepo.save(userRole);
        LOGGER.info("*************************************************** done saving");
        return userRepository.save(user);
    }

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getUserByUserName(String username) {
		User user = null;
		try{
			 user = userRepository.findByUserName(username);
		}
		catch(NonUniqueResultException e){
			LOGGER.info("Found more than two user with same username.");
			e.printStackTrace();
		}
		finally {
			return user;
		}
		
	}
	
	@Override
	public User getUserByEmail(String email) {
		LOGGER.info("finding user email ****************************************************");
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public Collection<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}	
}