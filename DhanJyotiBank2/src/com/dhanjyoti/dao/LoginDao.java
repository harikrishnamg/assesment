package com.dhanjyoti.dao;

import java.util.List;

import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;

public interface LoginDao {

	CustomerModel getCustomerInfo(String userName, String loginPassword);

	Account getAccountInfo(Integer customerID);

	List<AccountLog> getAccountLogList(Long account);

}
