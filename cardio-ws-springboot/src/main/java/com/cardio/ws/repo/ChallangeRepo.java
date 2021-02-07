package com.cardio.ws.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cardio.ws.model.Challange;

@Repository
public interface ChallangeRepo extends JpaRepository<Challange, Long>{

	

	
	  Challange findByChallangeName(String chtitle);
	  
	  
	 

}
