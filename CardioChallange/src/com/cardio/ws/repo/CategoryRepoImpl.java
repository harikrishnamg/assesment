package com.cardio.ws.repo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cardio.ws.model.Category;
@Repository
public class CategoryRepoImpl implements CategoryRepo{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		
		String hql = "FROM Category e where e.categoryName='"+name+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> results =(List<Category>) query.list();
		return results.get(0);
	}

}
