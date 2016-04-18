package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.utils.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.security")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig. class);
	
	 @Autowired 
	 private UserDetailsService userDetailsService;
	 
	 @Autowired
	 private LoginSuccessHandler successHandler;
	 
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception 
	 {    
		 LOGGER.info("in config aurh");
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	 } 

	
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception 
	 {
		 http		 
		 	.authorizeRequests()
		 		//.antMatchers("/hello", "/home", "/", "/user/**", "/iba/**").access("hasRole('ROLE_ADMIN')")
		 		//.antMatchers("/", "/home", "/user/**", "/iba/**").hasAuthority("0")
		 		.anyRequest().permitAll()
		 	.and()
		 		.formLogin().loginPage("/login").successHandler(successHandler)
		 		.usernameParameter("username").passwordParameter("password")
		 	.and()
		 		.logout()
		 			.logoutSuccessUrl("/login?logout") 
		 			.logoutUrl("/logout")
		 	.and()
		 		.exceptionHandling().accessDeniedPage("/403")
		 	.and()
		 		.csrf();
	 }
	
	 @Bean(name="passwordEncoder")
	 public PasswordEncoder passwordencoder()
	 {
	     return new BCryptPasswordEncoder();
	 }
}