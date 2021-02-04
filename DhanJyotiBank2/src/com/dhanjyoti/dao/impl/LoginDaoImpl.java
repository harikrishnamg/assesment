package com.dhanjyoti.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyoti.dao.LoginDao;
import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public CustomerModel getCustomerInfo(String userName, String loginPassword) {
		String hql = "FROM CustomerModel e where e.userName='"+userName+"' and e.loginPassword='"+loginPassword+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CustomerModel> customerList =(List<CustomerModel>) query.list();
		
		CustomerModel customerModel = null;
		if(customerList!=null &&  !customerList.isEmpty()){
			customerModel = customerList.get(0);
		}
		return customerModel;
	}

	@Transactional
	public Account getAccountInfo(Integer customerID) {
		String hql = "FROM Account e where e.customerID='"+customerID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Account> customerList =(List<Account>) query.list();
		Account account = null;
		if(customerList!=null &&  !customerList.isEmpty()){
			account = customerList.get(0);
		}
		return account;
	}

	@Transactional
	public List<AccountLog> getAccountLogList(Long account) {
		String hql = "FROM AccountLog e where e.account='"+account+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<AccountLog> logList =(List<AccountLog>) query.list();
		return logList;
	}
	
	
}
