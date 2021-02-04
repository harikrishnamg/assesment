package com.cardio.ws.repo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cardio.ws.model.Category;
import com.cardio.ws.model.Challange;
import com.cardio.ws.model.ChallangeResults;



@Repository
public class ChallangeRepoImpl implements ChallangeRepo{
	
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public Challange findByTitle(String chtitle) {
		String hql = "FROM Challange e where e.challangeName='"+chtitle+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Challange> results =(List<Challange>) query.list();
		return results.get(0);
	}
	@Transactional
	public List<ChallangeResults> getChallangeResults(Long challangeId) {
		String hql = "FROM ChallangeResults e where e.chid='"+challangeId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (List<ChallangeResults>) query.list();
	}
	
	@Transactional
	public void insertChallangeData(ChallangeResults chResult) {
		
		sessionFactory.getCurrentSession().save(chResult);

	}
	@Transactional
	public ChallangeResults getChallangeResult(Long chalID) {
		
		return (ChallangeResults) sessionFactory.getCurrentSession().get(ChallangeResults.class, chalID);
	}
	@Transactional
	public void updateEmployee(ChallangeResults result) {
		
		sessionFactory.getCurrentSession().update(result);
	}
	
	@Transactional
	public void deleteResult(Long chalID) {
		
		String hql = "delete ChallangeResults where recID="+chalID;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

}
