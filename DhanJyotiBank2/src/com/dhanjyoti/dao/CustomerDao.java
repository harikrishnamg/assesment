package com.dhanjyoti.dao;

import java.util.List;

import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.model.User;

public interface CustomerDao {

	int registerCustomer(CustomerModel customer);

	Account getAccountInfoByAccount(Long account);

	int updateBalance(Account account, AccountLog log);

	int submitBenificeryDetails(CustomerModel customer, User user);

	boolean checkCustomer(User user);

	List<Long> getBenificieryList(Integer customerID);

}
