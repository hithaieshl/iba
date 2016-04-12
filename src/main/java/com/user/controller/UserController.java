package com.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.user.forms.UserCreateForm;
import com.user.forms.UserRegisterForm;
import com.user.service.UserRegisterServiceImpl;
import com.user.service.UserService;
import com.user.validator.UserCreateFormValidator;

@Controller
@RequestMapping(value="user")
public class UserController {
	
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    
    @Autowired
    private UserRegisterServiceImpl userRegisterServiceImpl;
    
    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }
    
    @RequestMapping(value = "")
    public String home(Model model){
    	return "userHome";
    }
    
    @RequestMapping(value="/createUser", method = RequestMethod.GET)
    public String addModels(Model modelAndView) {
    	modelAndView.addAttribute("user", new UserCreateForm());
    	return "usercreate";
	}
    
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {

        userService.create(form);
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