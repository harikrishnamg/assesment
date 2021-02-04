package com.cardio.ws.repo;

import java.util.List;

import com.cardio.ws.model.Challange;
import com.cardio.ws.model.ChallangeResults;

public interface ChallangeRepo {

	Challange findByTitle(String chtitle);

	List<ChallangeResults> getChallangeResults(Long challangeId);

	void insertChallangeData(ChallangeResults chResult);

	ChallangeResults getChallangeResult(Long chalID);

	void updateEmployee(ChallangeResults result);

	void deleteResult(Long chalID);

}
