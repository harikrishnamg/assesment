package com.cardio.ws.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="CATEGERY")
public class Category implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CAT_ID")
	private Long categoryID;
	@Column(name="CAT_TITLE")
	private String categoryName;
	@OneToMany(fetch = FetchType.EAGER,targetEntity=Challange.class,mappedBy="category")	
	private List<Challange> challange;
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
	public List<Challange> getChallange() {
		return challange;
	}
	public void setChallange(List<Challange> challange) {
		this.challange = challange;
	}
	
	
}
