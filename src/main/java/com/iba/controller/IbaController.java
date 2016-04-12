package com.iba.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.createUser.service.UserServiceImpl;
import com.iba.forms.AddEmailForm;
import com.iba.forms.BankDetailsForm;
import com.iba.forms.PersonalDetailsForm;
import com.iba.service.IbaService;
import com.iba.validator.AddEmailValidator;

@Controller
@RequestMapping(value = "iba")
public class IbaController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private final IbaService ibaService;
	private final AddEmailValidator addEmailValidator;
	
	@Autowired
	public IbaController(
			IbaService ibaService,
			AddEmailValidator addEmailValidator) 
	{
		this.ibaService = ibaService;
		this.addEmailValidator = addEmailValidator;
	}

	@InitBinder("addEmailForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(addEmailValidator);
    }
	
	@RequestMapping(value = "/personalDetails", method = RequestMethod.GET)
	public String sendPersonalDetailsForm(Model model){
		model.addAttribute("personalDetails", new PersonalDetailsForm());
		return "personalDetails";
	}
	
	@RequestMapping(value = "/personalDetails", method = RequestMethod.POST)
	public String savePersonalDetailsForm(@Valid @ModelAttribute PersonalDetailsForm personalDetailsForm){
		ibaService.savePersonalDetails(personalDetailsForm);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/bankDetails", method = RequestMethod.GET)
	public String sendBankDetailsForm(Model model){
		model.addAttribute("bankDetails", new BankDetailsForm());
		return "bankDetails";
	}
	
	@RequestMapping(value = "/bankDetails", method = RequestMethod.POST)
	public String saveBankDetailsForm(@Valid @ModelAttribute BankDetailsForm bankDetailsForm){
		ibaService.saveBankDetails(bankDetailsForm);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/addEmail", method = RequestMethod.GET)
	public String addUser(Model model){
		model.addAttribute("addEmailForm", new AddEmailForm());
		return "addEmail";
	}
	
	@RequestMapping(value = "/addEmail", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute AddEmailForm addEmailForm, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "addEmail";
		}
		else{
			ibaService.saveEmail(addEmailForm);
			return "redirect:/home";
		}
	}
}
