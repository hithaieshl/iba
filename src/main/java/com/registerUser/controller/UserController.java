package com.registerUser.controller;

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
import com.registerUser.forms.UserCreateForm;
import com.registerUser.forms.UserRegisterForm;
import com.registerUser.service.UserRegisterServiceImpl;
import com.registerUser.service.UserService;
import com.registerUser.validator.UserCreateFormValidator;

@Controller
@RequestMapping(value="user")
public class UserController {
	
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    
    @Autowired
    private UserRegisterServiceImpl userRegisterServiceImpl;
    
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
    
    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String addModels(Model modelAndView) {
    	modelAndView.addAttribute("user", new UserCreateForm());
    	return "usercreate";
	}
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {

    	if (bindingResult.hasErrors()) {
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
    
    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    public String sendUserRegisterForm(Model model){
    	model.addAttribute("userRegister" ,new UserRegisterForm());
    	return "userRegister";
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String getUserRegisterForm(@Valid @ModelAttribute("userRegisterForm") UserRegisterForm userRegisterForm, BindingResult bindingResult){
    	userRegisterServiceImpl.saveUser(userRegisterForm);
    	return "redirect:/home";
    }
    
}