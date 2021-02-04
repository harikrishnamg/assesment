package com.dhanjyoti.service;

import java.util.List;

import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;

public interface BankUserService {

	public List<CustomerModel> getCustomersToAuthorize();

	public CustomerModel getCustomerByID(Integer id);

	

	public Long activateCustomerAndCreateAccoun(Account account, CustomerModel customer);

	public int updateAccountLog(AccountLog accountLog);

	public int checkBankUser(String userName, String loginPassword);
}
