package com.dhanjyoti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.model.User;

public interface CustomerService {
 
	public int registerCustomer(CustomerModel customer);

	public Account getAccountInfoByAccount(Long account);

	public int updateBalance(Account account, AccountLog log);

	public int submitBenificeryDetails(CustomerModel customer, User user);

	public boolean checkCustomer(User user);

	public List<Long> getBenificieryList(Integer customerID);
	
}
