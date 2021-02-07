package com.cardio.ws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardio.ws.model.Challange;
import com.cardio.ws.model.ChallangeResults;
import com.cardio.ws.repo.ChallangeRepo;
import com.cardio.ws.repo.ChallangeResultsRepo;

@Service
public class ChallangeServiceImple implements ChallangeService{

	@Autowired
	private ChallangeRepo challangeRepo;
	@Autowired
	private ChallangeResultsRepo challangeResultsRepo;
	public Challange findByTitle(String chtitle) {
		
		
		return challangeRepo.findByChallangeName(chtitle);
	}
	
	/*
	 * public List<ChallangeResults> getChallangeResults(Long challangeId) {
	 * 
	 * List<ChallangeResults> obj = challangeResultsRepo.findAllById(new
	 * List().add(challangeId));
	 * 
	 * return obj; }
	 */

	
	public void insertChallangeData(ChallangeResults chResult) {
		
		//challangeResultsRepo.insertChallangeData(chResult);
		
		challangeResultsRepo.save(chResult);
	}

	
	public ChallangeResults getChallangeResult(Long chalID) {
		
		Optional<ChallangeResults> obj = challangeResultsRepo.findById(chalID);
		return obj.get();
	}

	
	

	
	public void deleteResult(Long chalID) {
		
		challangeResultsRepo.deleteById(chalID);
	}

	
	public void updateResults(ChallangeResults result) {
		
		challangeResultsRepo.save(result);
		
	}

	public List<ChallangeResults> getChallangeResults(Long challangeId) {
	
		List<Long> id = new ArrayList();
		List<ChallangeResults> list=	challangeResultsRepo.findAllById(id);
		return list;
	}

	

}
