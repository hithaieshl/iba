package com;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.user.forms.PasswordResetForm;
import com.user.service.UserService;

@RequestMapping(value="")
@Controller
public class ControllerClass {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerClass. class);
    private final UserService userService;

    @Autowired
    public ControllerClass(UserService userService) {
    	this.userService = userService;
    }
    
    @RequestMapping(value="/passwordReset", method = RequestMethod.GET)
    public String sendPasswordReset(Model modelAndView){
    	LOGGER.info("%%%%%%%%%%%%   in send passeord");
    	modelAndView.addAttribute("passwordReset", new PasswordResetForm());
    	return "passwordReset";
    }
    
    @RequestMapping(value="/passwordReseter", method = RequestMethod.GET)
    public String savePassword(@Valid @ModelAttribute("passwordReset") PasswordResetForm passwordReset){
    	LOGGER.info("###########   in save password");
    	userService.saveNewPassword(passwordReset);
    	return "redirect:/home";
    }
}