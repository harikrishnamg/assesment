package com.dhanjyoti.dao;

import java.util.List;

import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;

public interface BankUserDao {

	List<CustomerModel> getCustomersToAuthorize();

	CustomerModel getCustomerByID(Integer id);	

	Long activateCustomerAndCreateAccoun(Account account, CustomerModel customer);

	int updateAccountLog(AccountLog accountLog);

	int checkBankUser(String userName, String loginPassword);

}
