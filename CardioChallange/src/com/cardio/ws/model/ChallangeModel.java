package com.cardio.ws.model;

import java.util.List;


public class ChallangeModel {

	
	private Long challangeId;
	
	private String challangeName;
	
	private List<ChallangeResults>	challangeResults;
	
	
	
	
	
	public Long getChallangeId() {
		return challangeId;
	}
	public void setChallangeId(Long challangeId) {
		this.challangeId = challangeId;
	}
	public String getChallangeName() {
		return challangeName;
	}
	public void setChallangeName(String challangeName) {
		this.challangeName = challangeName;
	}
	
	public List<ChallangeResults> getChallangeResults() {
		return challangeResults;
	}
	public void setChallangeResults(List<ChallangeResults> challangeResults) {
		this.challangeResults = challangeResults;
	}
}
