package com.cardio.ws.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cardio.ws.model.ChallangeResults;

@Repository
public interface ChallangeResultsRepo  extends JpaRepository <ChallangeResults, Long>{
}
