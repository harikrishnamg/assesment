package com.dhanjyoti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanjyoti.dao.LoginDao;
import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
@Autowired
LoginDao loginDao;

@Override
public CustomerModel getCustomerInfo(String userName, String loginPassword) {
	// TODO Auto-generated method stub
	return loginDao.getCustomerInfo(userName,loginPassword);
}

@Override
public Account getAccountInfo(Integer customerID) {
	// TODO Auto-generated method stub
	return loginDao.getAccountInfo(customerID);
}

@Override
public List<AccountLog> getAccountLogList(Long account) {
	// TODO Auto-generated method stub
	return loginDao.getAccountLogList(account);
}

}
