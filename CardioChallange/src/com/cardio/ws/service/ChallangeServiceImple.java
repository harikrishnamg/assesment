package com.cardio.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardio.ws.model.Challange;
import com.cardio.ws.model.ChallangeResults;
import com.cardio.ws.repo.ChallangeRepo;

@Service
public class ChallangeServiceImple implements ChallangeService{

	@Autowired
	private ChallangeRepo challangeRepo;
	
	public Challange findByTitle(String chtitle) {
		
		return challangeRepo.findByTitle(chtitle);
	}
	
	public List<ChallangeResults> getChallangeResults(Long challangeId) {
		
		return challangeRepo.getChallangeResults(challangeId);
	}

	
	public void insertChallangeData(ChallangeResults chResult) {
		
		challangeRepo.insertChallangeData(chResult);
		
	}

	
	public ChallangeResults getChallangeResult(Long chalID) {
		
		return challangeRepo.getChallangeResult( chalID);
	}

	
	public void updateEmployee(ChallangeResults employee) {
		
		challangeRepo.updateEmployee(employee);
	}

	
	public void deleteResult(Long chalID) {
		
		challangeRepo.deleteResult(chalID);
	}

}
