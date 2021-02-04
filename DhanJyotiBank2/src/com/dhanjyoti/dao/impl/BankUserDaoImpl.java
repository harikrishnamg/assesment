package com.dhanjyoti.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyoti.dao.BankUserDao;
import com.dhanjyoti.model.Account;
import com.dhanjyoti.model.AccountLog;
import com.dhanjyoti.model.BankUserModel;
import com.dhanjyoti.model.CustomerModel;
@Repository
public class BankUserDaoImpl implements BankUserDao{
    @Autowired
    SessionFactory sessionFactory;
    
	@Transactional
	public List<CustomerModel> getCustomersToAuthorize() {
		String hql = "FROM CustomerModel e where e.customerStat='Registered'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CustomerModel> results =(List<CustomerModel>) query.list();
		
		return results;
	}

	@Transactional
	public CustomerModel getCustomerByID(Integer id) {
		
		return (CustomerModel) sessionFactory.getCurrentSession().get(CustomerModel.class, id);
	}

	
 

	@Transactional
	public Long activateCustomerAndCreateAccoun(Account account, CustomerModel customer) {
		
	Session session =  sessionFactory.getCurrentSession();
	Long i =(Long) session.save(account);
	
	session.update(customer);
		return i;
	}

	@Transactional
	public int updateAccountLog(AccountLog accountLog) {
	return	(int) sessionFactory.getCurrentSession().save(accountLog);
	}

	@Transactional
	public int checkBankUser(String userName, String loginPassword) {
		String hql = "FROM BankUserModel e where e.loginId='"+userName+"' and e.loginPwd='"+loginPassword+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<BankUserModel> results =(List<BankUserModel>) query.list();
		int i = 0;
		if(results!=null ){
			i=results.size();
		}
		
		return i;
	}

}
