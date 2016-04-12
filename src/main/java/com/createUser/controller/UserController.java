package com.createUser.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.createUser.domain.UserCreateForm;
import com.createUser.service.UserService;
import com.createUser.validator.UserCreateFormValidator;

@Controller
@RequestMapping(value="user")
public class UserController {
	
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }
    
    @RequestMapping(value="", method = RequestMethod.GET)
    public String addModels(Model modelAndView) {
    	modelAndView.addAttribute("user", new UserCreateForm());
    	return "usercreate";
	}
    
   /* @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView getUserCreatePage() {
    	LOGGER.info("*********************************************getUserCreatePage");
    	return new ModelAndView("usercreate", "form", new UserCreateForm());
    }*/

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
    	LOGGER.info("*********************************************handleUserCreateForm");

    	if (bindingResult.hasErrors()) {
    		LOGGER.info("*********************************** inside if condition");
    		LOGGER.info("**************************binding errors-->" + bindingResult.getAllErrors());
            return "usercreate";
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "usercreate";
        }
        return "redirect:/user";
    }

}