package com.dhanjyoti.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.model.User;
import com.dhanjyoti.service.BankUserService;
import com.dhanjyoti.service.CustomerService;
import com.dhanjyoti.validators.LoginValidator;
@Controller
public class BankUserController {
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	@Autowired
	LoginValidator loginValid;
	@Autowired
	BankUserService bankUserService;
	@Autowired
	CustomerService customerService;
	@RequestMapping(value = "/banklogin", method = RequestMethod.GET)
	public ModelAndView  Banklogin(@ModelAttribute("userForm") User user,BindingResult result,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		boolean flag = (boolean) (session.getAttribute("userLoginFlag")==null?true:session.getAttribute("userLoginFlag"));
		ModelAndView model = new ModelAndView();
		
		
		 if(flag==false)
		 {
		loginValid.validate(user, result);
		if (result.hasErrors()) {
			System.out.println("Registration Page errors::"+result.getErrorCount());
			model.addObject(user);
			model.setViewName("BankUserLogin");
			flag = false;
			return model;
		} else {
			int i = bankUserService.checkBankUser(user.getUserName(),user.getLoginPassword());
			if(i==0){
				model.addObject(user);
				model.setViewName("BankUserLogin");
				model.addObject("errorMsg","Please check UserName and Password");
				flag = false;
				return model;
				
			}
		}}
			
			List<CustomerModel> customerList = bankUserService.getCustomersToAuthorize();
			session.setAttribute("userLoginFlag", true);
			model.addObject("customerList",customerList);
			model.addObject(user);
			model.setViewName("BankUserOverView");
			return model;
		}
		
	
	@RequestMapping(value = "/depositMoneyHome", method = RequestMethod.GET)
	public ModelAndView depositHome(@ModelAttribute("userForm") User user) {
		
	
		ModelAndView model = new ModelAndView();
		model.addObject("userForm", user);
		
		model.setViewName("DepositHome");
		return model;

	}
	@RequestMapping(value = "/depositMoney", method = RequestMethod.POST)
	public String depositMoney(@ModelAttribute("userForm") User user,HttpServletRequest request) {
		request.getSession().setAttribute("userLoginFlag", true);
		Account account= customerService.getAccountInfoByAccount(user.getAccount());
		ModelAndView model = new ModelAndView();
		 AccountLog log = new AccountLog();
		 if(account!=null){
			 account.setBalance(account.getBalance()+user.getBalance());
			 log.setCreditAmount(user.getBalance());
			 log.setDebitAmount(0.0);
			 log.setAccount(account.getAccount());
			 log.setLogDate(new Date());
			 int i = customerService.updateBalance(account,log);
			 model.addObject("userForm", user);
			 request.getSession().setAttribute("depositStatus", "MoneyAddedToCustomer");
		 }
		
		 return  "redirect:/banklogin";

	}
	
	
	@RequestMapping(value = "/getCustomerData/{id}", method = RequestMethod.GET)
	public ModelAndView getCustomer(@PathVariable Integer id ,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("CustomerID::"+id);
		CustomerModel customer = bankUserService.getCustomerByID(id);
		request.getSession().setAttribute("customerBankSide", customer);
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer",customer);
		mv.setViewName("CustomerDetails");
		return mv;

	}
	
	@RequestMapping(value = "/customerActivation", method = RequestMethod.GET)
	public ModelAndView customerActivation(@RequestParam(name="actiontype") String actinType ,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("actionType::"+actinType);
		int stat =0;
		ModelAndView model = new ModelAndView();
	
		if(actinType!=null && actinType.equals("approve")){
			CustomerModel customer = (CustomerModel) request.getSession().getAttribute("customerBankSide");
			customer.setCustomerStat("Active");
			Account account = new Account();
			AccountLog accountLog = new AccountLog();
			
			if(customer!=null){
				account.setCustomerID(customer.getCustomerID());
				account.setMobile(customer.getMobile());
				String accountNo= randomAlphaNumeric(11);
				
				account.setBalance(new Double(500));
				account.setAccStatus("Active");
			Long accountSaved = bankUserService.activateCustomerAndCreateAccoun(account,customer);
				accountLog.setAccount(accountSaved);
				accountLog.setCreditAmount(new Double(500));
				accountLog.setLogDate(new Date());
				
				
				stat = bankUserService.updateAccountLog(accountLog);
			}
			List<CustomerModel> customerList = bankUserService.getCustomersToAuthorize();
			
			model.addObject("customerList",customerList);
			model.addObject((User)request.getSession().getAttribute("user"));
			model.setViewName("BankUserOverView");
			
		}
		else if(actinType!=null && actinType.equals("reject")){
			List<CustomerModel> customerList = bankUserService.getCustomersToAuthorize();
			
			model.addObject("customerList",customerList);
			model.addObject((User)request.getSession().getAttribute("user"));
			model.setViewName("BankUserOverView");
			return model;
		}
		
		
		return model;
		

	}
	private  String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
		}
}
