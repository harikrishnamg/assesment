package com.dhanjyoti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.model.User;
import com.dhanjyoti.service.LoginService;
import com.dhanjyoti.validators.LoginValidator;
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	LoginValidator loginValid;
	@RequestMapping(value = "/customerLogin")
	public String customerLogin(Model model,HttpServletRequest request){
		User user = new User();
		HttpSession session = request.getSession();
		System.out.println("User Page Requested");
		model.addAttribute("userForm",user);
		session.setAttribute("loginFlag", false);
		return "LoginHome";
	}
	
	@RequestMapping(value = "/userLogin")
	public String userLogin(Model model){
		User user = new User();
		System.out.println("User Page Requested");
		model.addAttribute("userForm",user);
		return "BankUserLogin";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("userForm") User user,BindingResult result,HttpServletRequest request) {
		System.out.println("Over View::"+user.getUserName()+"::"+user.getLoginPassword());
		HttpSession session = request.getSession();
		boolean flag = (boolean) session.getAttribute("loginFlag");
		CustomerModel customer = (CustomerModel) session.getAttribute("customer");
		ModelAndView model = new ModelAndView();
		model.addObject("userForm",user);
		if(flag==false){
		loginValid.validate(user, result);
		if (result.hasErrors()) {
			System.out.println("Registration Page errors::"+result.getErrorCount());
			model.setViewName("LoginHome");
			flag =false;
			return model;
		} else {
			 customer =loginService.getCustomerInfo(user.getUserName(),user.getLoginPassword());
			if(customer==null){
				model.setViewName("LoginHome");
				model.addObject("errorMsg","Login Failed Please check UserName and Password");
				flag =false;
				return model;
			}
		}
		}
			Account account = loginService.getAccountInfo(customer.getCustomerID());
			List<AccountLog> logList = loginService.getAccountLogList(account.getAccount());
			if(logList==null){
				logList = new ArrayList<AccountLog>();
			}
			flag= true;
			model.addObject("accountInfo",account);
			model.addObject("logList",logList);
			model.addObject("customer",customer);
			model.setViewName("AccountOverView");
			session.setAttribute("customer", customer);
			session.setAttribute("accountInfo", account);
			session.setAttribute("loginFlag", flag);
			return model;
		
		
	}
	
	@RequestMapping(value = "/userLogout")
	public String userLogout(Model model){
		User user = new User();		
		model.addAttribute("userForm",user);
		//return "BankUserLogin";
		return "redirect:/";
	}
	@RequestMapping(value = "/customerLogout")
	public String customerLogout(Model model){
		User user = new User();
		
		model.addAttribute("userForm",user);
		//return "LoginHome";
		return "redirect:/";
	}
	
}
