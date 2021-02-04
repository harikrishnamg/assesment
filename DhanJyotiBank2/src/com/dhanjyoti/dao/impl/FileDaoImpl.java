package com.dhanjyoti.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyoti.dao.FileDao;
import com.dhanjyoti.model.CustomerKypDocs;
@Repository
public class FileDaoImpl implements FileDao{
    @Autowired
    SessionFactory sessionFactory;
	@Transactional
	public CustomerKypDocs getCustomerKYPDoc(Integer id) {
		// TODO Auto-generated method stub
		return (CustomerKypDocs)sessionFactory.getCurrentSession().get(CustomerKypDocs.class, id);
	}

}
