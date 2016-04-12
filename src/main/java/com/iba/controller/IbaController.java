package com.iba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iba.forms.BankDetailsForm;
import com.iba.forms.PersonalDetailsForm;
import com.iba.service.IbaService;

@Controller
@RequestMapping(value = "iba")
public class IbaController {
	
	private final IbaService ibaService;
	
	@Autowired
	public IbaController(
			IbaService ibaService) 
	{
		this.ibaService = ibaService;
	}
	
	
	@RequestMapping(value = "")
	public String ibaHome(Model model){
		return "ibaHome";
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

}
