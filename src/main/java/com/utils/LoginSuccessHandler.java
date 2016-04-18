package com.utils;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler  extends SimpleUrlAuthenticationSuccessHandler{
	
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSuccessHandler. class);
	    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	     
	    @Override
	    protected void handle(HttpServletRequest request, 
	      HttpServletResponse response, Authentication authentication) throws IOException {
	        String targetUrl = determineTargetUrl(authentication);
	  
	        if (response.isCommitted()) {
	            System.out.println("Can't redirect");
	            return;
	        }
	  
	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }

		private String determineTargetUrl(Authentication authentication) {
	        Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();
	        boolean enabled = true;
	        String zero = "0";
	        
	        for(GrantedAuthority authority : authorities){
	        	LOGGER.info("@@@@@@@" + authority.getAuthority());
	        	LOGGER.info("!!!!!!!!" + authority.getAuthority().equals(zero));
	        	if (authority.getAuthority().equals(zero)){
	        		LOGGER.info("**************** zero");
	        		enabled = false;
	        	}
	        }
	        if(enabled){
	        	LOGGER.info("&&&&&&&&&&&&&&&&  true");
		        return "home";
	        }
	        else {
	        	LOGGER.info("%%%%%%%%%%%%%  false");
				return "passwordReset";
			}
		}
	     
}
