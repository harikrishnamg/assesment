package com.dhanjyoti.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dhanjyoti.model.User;
@Component
public class LoginValidator implements Validator{

	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	
	@Override
	public void validate(Object arg0, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName","error.userName","Please enter your UserName.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"loginPassword","error.loginPassword","Please enter your Password.");		
	}

}
