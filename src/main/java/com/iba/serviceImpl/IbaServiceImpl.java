package com.iba.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.iba.domain.BankDetails;
import com.iba.domain.BankDetailsRepository;
import com.iba.domain.PersonalDetails;
import com.iba.domain.PersonalDetailsRepository;
import com.iba.forms.BankDetailsForm;
import com.iba.forms.PersonalDetailsForm;
import com.iba.service.IbaService;

@Service
@Component
public class IbaServiceImpl implements IbaService{

	private final PersonalDetailsRepository personalDetailsRepository;
	private final BankDetailsRepository bankDetailsRepository;

	@Autowired
	public IbaServiceImpl(
			PersonalDetailsRepository personalDetailsRepository,
			BankDetailsRepository bankDetailsRepository) 
	{
		this.personalDetailsRepository = personalDetailsRepository;
		this.bankDetailsRepository = bankDetailsRepository;
	}
	
	@Override
	public PersonalDetails savePersonalDetails(PersonalDetailsForm form) {
		
		PersonalDetails personalDetails = new PersonalDetails();
		
		personalDetails.setFirst_name(form.getFirst_name());
		personalDetails.setMiddle_name(form.getMiddle_name());
		personalDetails.setLast_name(form.getLast_name());
		personalDetails.setDob(form.getDob());
		personalDetails.setFather_name(form.getFather_name());
		personalDetails.setMother_name(form.getMother_name());
		personalDetails.setGender(form.getGender());
		personalDetails.setMarital_status(form.getMarital_status());
		personalDetails.setContact_num(form.getContact_num());
		personalDetails.setPan_num(form.getPan_num());
		personalDetails.setDate_of_joining(form.getDate_of_joining());
		personalDetails.setDepartment(form.getDepartment());
		personalDetails.setDesignation(form.getDesignation());
		personalDetails.setLocation(form.getLocation());
		
		personalDetailsRepository.save(personalDetails);
		return personalDetails;
	}
	
	@Override
	public BankDetails saveBankDetails(BankDetailsForm bankDetailsForm) {
		
		BankDetails bankDetails = new BankDetails();
		
		bankDetails.setBankName(bankDetailsForm.getBankName());
		bankDetails.setBankBranch(bankDetailsForm.getBankBranch());
		bankDetails.setAccountHolderName(bankDetailsForm.getAccountHolderName());
		bankDetails.setAccountNum(bankDetailsForm.getAccountNumber());
		bankDetails.setIfscCode(bankDetailsForm.getIfscCode());
		
		bankDetailsRepository.save(bankDetails);
		return bankDetails;
		
	}
	
}
















