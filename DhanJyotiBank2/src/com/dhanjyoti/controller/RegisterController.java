package com.dhanjyoti.controller;




import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyoti.model.CustomerKypDocs;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.model.User;
import com.dhanjyoti.service.CustomerService;
import com.dhanjyoti.validators.RegistrationValidator;



@Controller
public class RegisterController {
	
	@Autowired
	RegistrationValidator registrationValidator;
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/register")
	public String user(Model model) {
		User user = new User();
		System.out.println("User Page Requested");
		model.addAttribute("userForm",user);
		return "Registration";
		
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("userForm") User user,BindingResult result,HttpServletRequest request,
	        HttpServletResponse response) throws IOException, ParseException {
		System.out.println("Registration Page");
		registrationValidator.validate(user, result);
		if (result.hasErrors()) {
			System.out.println("Registration Page errors::"+result.getErrorCount());
		return new ModelAndView("Registration");
		} else {
			CustomerModel customerModel = new CustomerModel();
			customerModel.setAadhar(user.getAadhar());
			customerModel.setAddress1(user.getAddress1());
			customerModel.setAddress2(user.getAddress2());
			customerModel.setCity(user.getCity());			
			customerModel.setCustomerStat("Registered");
			customerModel.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(user.getDateOfBirth()));
			customerModel.setEmail(user.getEmail());
			customerModel.setFirstName(user.getFirstName());
			customerModel.setLastName(user.getLastName());
			customerModel.setLoginPassword(user.getLoginPassword());
			customerModel.setMobile(user.getMobile());			
			customerModel.setPin(user.getPin());
			customerModel.setPan(user.getPan());
			customerModel.setState(user.getState());
			customerModel.setUserName(user.getUserName());
			List<CustomerKypDocs> docList = new ArrayList<CustomerKypDocs>();
			CustomerKypDocs addressFile = getUploadedDocument(user.getAddressFile());
			addressFile.setFileName("AddressFile");
			addressFile.setCustomer(customerModel);
			CustomerKypDocs aadharFile = getUploadedDocument(user.getAadharFile());
			aadharFile.setFileName("AadharFile");
			aadharFile.setCustomer(customerModel);
			CustomerKypDocs panFile = getUploadedDocument(user.getPanFile());
			panFile.setFileName("PANFile");
			panFile.setCustomer(customerModel);
			CustomerKypDocs dobFile = getUploadedDocument(user.getDobFile());
			dobFile.setFileName("DOBFile");
			dobFile.setCustomer(customerModel);
			docList.add(dobFile);
			docList.add(aadharFile);
			docList.add(addressFile);
			docList.add(panFile);
			customerModel.setCustomerDocs(docList);
			int i = customerService.registerCustomer(customerModel);
			if(i>0){
			return new ModelAndView("RegistrationSucess","RegistrationSuccess",null);
			}
			else{
				return new ModelAndView("Registration");
			}
		}
		
	}
	private CustomerKypDocs getUploadedDocument(MultipartFile customerFile) {
		CustomerKypDocs customerDoc = new CustomerKypDocs();
		
		try {
			customerDoc.setDocName(customerFile.getName());
			customerDoc.setDocDescription(customerFile.getOriginalFilename());
			customerDoc.setDocType(customerFile.getContentType());
			customerDoc.setDocContent(customerFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerDoc;
	}
	
	
	
}
