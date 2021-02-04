package com.dhanjyoti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanjyoti.dao.BankUserDao;
import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.service.BankUserService;
@Service
public class BankUserServiceImpl implements BankUserService{
	@Autowired
	BankUserDao bankUserDao;
	
	public List<CustomerModel> getCustomersToAuthorize() {
		// TODO Auto-generated method stub
		return bankUserDao.getCustomersToAuthorize();
	}

	public CustomerModel getCustomerByID(Integer id) {
		// TODO Auto-generated method stub
		return bankUserDao.getCustomerByID(id);
	}

	@Override
	public Long activateCustomerAndCreateAccoun(Account account, CustomerModel customer) {
		// TODO Auto-generated method stub
		return bankUserDao.activateCustomerAndCreateAccoun(account,customer);
	}

	@Override
	public int updateAccountLog(AccountLog accountLog) {
		// TODO Auto-generated method stub
		return bankUserDao.updateAccountLog(accountLog);
	}

	@Override
	public int checkBankUser(String userName, String loginPassword) {
		// TODO Auto-generated method stub
		return bankUserDao.checkBankUser(userName,loginPassword);
	}

}
