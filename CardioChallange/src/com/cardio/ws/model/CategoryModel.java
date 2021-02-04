package com.cardio.ws.model;

import java.util.List;


public class CategoryModel {

	private Long categoryID;

	private String categoryName;
	
	private List<ChallangeModel> challange;

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ChallangeModel> getChallange() {
		return challange;
	}

	public void setChallange(List<ChallangeModel> challange) {
		this.challange = challange;
	}
	
	
}
