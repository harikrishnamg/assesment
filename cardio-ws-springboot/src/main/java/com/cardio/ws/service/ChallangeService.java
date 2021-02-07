package com.cardio.ws.service;

import java.util.List;
import com.cardio.ws.model.Challange;
import com.cardio.ws.model.ChallangeResults;

public interface ChallangeService {

	Challange findByTitle(String chtitle);

	List<ChallangeResults> getChallangeResults(Long challangeId);

	void insertChallangeData(ChallangeResults chResult);

	ChallangeResults getChallangeResult(Long chalID);

	void updateResults(ChallangeResults result);

	void deleteResult(Long chalID);

}
