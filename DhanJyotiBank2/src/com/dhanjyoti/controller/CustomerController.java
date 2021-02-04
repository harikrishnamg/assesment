package com.dhanjyoti.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.model.User;
import com.dhanjyoti.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@RequestMapping(value = "/fundTransferAction" )
	public ModelAndView fundTransfer(@ModelAttribute("userForm") User user,HttpServletRequest request){
		CustomerModel customer = (CustomerModel) request.getSession().getAttribute("customer");
		List<Long> list = customerService.getBenificieryList(customer.getCustomerID());
		ModelAndView model = new ModelAndView();
		model.addObject("userForm", user);
		model.addObject("benList",list);
		model.setViewName("FundTransferPage");
		return model;
		
	}
	@RequestMapping(value = "/transfer" )
	public String amountTransfer(@ModelAttribute("userForm") User user,HttpServletRequest request){
		 Account account= customerService.getAccountInfoByAccount(user.getAccount());
		 Account mainAccount = (Account) request.getSession().getAttribute("accountInfo");
		 ModelAndView model = new ModelAndView();
		 AccountLog log = new AccountLog();
		 if(account!=null ){
			 if(mainAccount.getBalance()<user.getBalance()){
				 model.addObject("user", new User());
				 request.getSession().setAttribute("transferStatus","Not EnoughFund");
			   
				 return  "redirect:/login";
			 }
			 else{
			 account.setBalance(account.getBalance()+user.getBalance());
			
			 mainAccount.setBalance(mainAccount.getBalance()-user.getBalance());
			 log.setAccount(mainAccount.getAccount());
			 log.setDebitAmount(user.getBalance());
			 log.setLogDate(new Date());
			 customerService.updateBalance(mainAccount, log);
			 log.setCreditAmount(user.getBalance());
			 log.setDebitAmount(0.0);
			 log.setAccount(account.getAccount());
			 log.setLogDate(new Date());
			 int i = customerService.updateBalance(account,log);
			 model.addObject("userForm", user);
			 request.getSession().setAttribute("transferStatus", "FundTransferedSuccessFully");
			 return  "redirect:/login";
			 }
		 }
		 else{
			     model.addObject("user", new User());
			     request.getSession().setAttribute("transferStatus", "CheckAccount");
				 model.setViewName("FundTransferPage");
		 }
		
		 return  "redirect:/login";
		
	}
	@RequestMapping(value = "/addBenificiery" )
	public ModelAndView addBenificiery(@ModelAttribute("userForm") User user){
		
	
		ModelAndView model = new ModelAndView();
		model.addObject("userForm", user);
		model.setViewName("AddBenificery");
		return model;
		
	}
	@RequestMapping(value = "/submitBenificiery" )
	public String submitBenificery(@ModelAttribute("userForm") User user,HttpServletRequest request){
		CustomerModel customer = (CustomerModel) request.getSession().getAttribute("customer");
		boolean accountCheck = customerService.checkCustomer(user);
		if(accountCheck==false){
			request.getSession().setAttribute("transferStatus", "Account Not Valid");
		}
		else{
		int i= customerService.submitBenificeryDetails(customer,user);
		if(i>0){
		 request.getSession().setAttribute("transferStatus", "Benificery Added");
		}
		else {
			request.getSession().setAttribute("transferStatus", "Benificery Not Added");
		}
		}
		 return  "redirect:/login";
		
	}
	
	
}
