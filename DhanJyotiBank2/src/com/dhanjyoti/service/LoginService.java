package com.dhanjyoti.service;

import java.util.List;

import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;

public interface LoginService {

	CustomerModel getCustomerInfo(String userName, String loginPassword);

	Account getAccountInfo(Integer customerID);

	List<AccountLog> getAccountLogList(Long account);

}
