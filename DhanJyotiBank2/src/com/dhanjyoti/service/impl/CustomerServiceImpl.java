package com.dhanjyoti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyoti.dao.CustomerDao;
import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.model.User;
import com.dhanjyoti.service.CustomerService;
@Service ("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	@Transactional
	public int registerCustomer(CustomerModel customer) {
		
		return customerDao.registerCustomer(customer);
	}
	@Transactional
	public Account getAccountInfoByAccount(Long account) {
		// TODO Auto-generated method stub
		return customerDao.getAccountInfoByAccount(account);
	}
	@Transactional
	public int updateBalance(Account account, AccountLog log) {
		// TODO Auto-generated method stub
		return customerDao.updateBalance(account,log);
	}
	@Override
	public int submitBenificeryDetails(CustomerModel customer, User user) {
		// TODO Auto-generated method stub
		return customerDao.submitBenificeryDetails(customer,user);
	}
	@Override
	public boolean checkCustomer(User user) {
		// TODO Auto-generated method stub
		return customerDao.checkCustomer(user);
	}
	@Override
	public List<Long> getBenificieryList(Integer customerID) {
		// TODO Auto-generated method stub
		return customerDao.getBenificieryList(customerID);
	}

}
