package com.dhanjyoti.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dhanjyoti.model.User;

@Component
public class RegistrationValidator implements Validator{
	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	
	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","error.email","Please enter your e-mail.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","error.firstName","Please enter your First Name.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","error.lastName","Please enter your Last Name.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"dateOfBirth","error.dateOfBirth","Please enter your Date of Birth.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address1","error.address1","Please enter your Address1.");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"city","error.city","Please enter your City.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"state","error.state","Please enter your State.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pin","error.pin","Please enter your PIN.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mobile","error.mobile","Please enter your Mobile.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"aadhar","error.aadhar","Please enter your Aadhar.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pan","error.pan","Please enter your PAN.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName","error.userName","Please enter your UserName.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"loginPassword","error.loginPassword","Please enter your Password.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"confirmPassword","error.confirmPassword","Please enter your Confirm Password.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"dobFile","error.dobFile","Please enter your dobFile.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"addressFile","error.addressFile","Please enter your addressFile.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"aadharFile","error.aadharFile","Please enter your aadharFile.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"panFile","error.panFile","Please enter your panFile.");
	}
}
