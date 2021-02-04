package com.dhanjyoti.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyoti.dao.CustomerDao;
import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.CustomerModel;
import com.dhanjyoti.model.User;
@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public int registerCustomer(CustomerModel customer) {
		 return (int) sessionFactory.getCurrentSession().save(customer);
		 
	}

	@Transactional
	public Account getAccountInfoByAccount(Long account) {
		
		return (Account) sessionFactory.getCurrentSession().get(Account.class, account);
	}

	@Transactional
	public int updateBalance(Account account, AccountLog log) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(account);
	return	(int) sessionFactory.getCurrentSession().save(log);
	}

	@Transactional
	public int submitBenificeryDetails(CustomerModel customer, User user) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().
				createSQLQuery("insert into DHANJYOTI_CUSTOMER_BENIFICIERY(ACCOUNT, BENIFICERY_ACCOUNT,BENIFICERY_NAME)"
						+ " values(" +customer.getCustomerID()+","+user.getAccount()+",'"+user.getFirstName()+"')");
    			;
int result = query.executeUpdate();
		return result;
	}

	@Transactional
	public boolean checkCustomer(User user) {
		// TODO Auto-generated method stub
	Account account=	(Account) sessionFactory.getCurrentSession().get(Account.class, user.getAccount());
	if(account==null){
		return false;
	}
	else{
		return true;
	}
		
	}

	@Transactional
	public List<Long> getBenificieryList(Integer customerID) {
		Query query = sessionFactory.getCurrentSession().
				createSQLQuery("select BENIFICERY_ACCOUNT from DHANJYOTI_CUSTOMER_BENIFICIERY where ACCOUNT="+customerID
						);
    			List<Long> list = query.list();
		return list;
	}
}
