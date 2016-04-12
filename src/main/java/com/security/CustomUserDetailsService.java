package com.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.domain.User;
import com.domain.UserRepository;
import com.domain.RoleRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{	
	private final UserRepository userRepository;
	private final RoleRepository userRoleRepository;
	
	@Autowired
    public CustomUserDetailsService(UserRepository userRepository,RoleRepository userRolesRepository) 
	{
        this.userRepository = userRepository;
        this.userRoleRepository=userRolesRepository;
    }
        
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user=userRepository.findByUserName(username);
		if(null == user)
		{
			throw new UsernameNotFoundException("No user present with username: "+username);
		}
		else
		{
			List<String> userRoles=userRoleRepository.findRoleByUserName(username);
			return new CustomUserDetails(user,userRoles);
		}
	}		
}
