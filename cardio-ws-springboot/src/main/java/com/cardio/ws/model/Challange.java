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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="CHALLANGE")
public class Challange implements Serializable {
	@Id
	@SequenceGenerator(name="accountLogSequence",sequenceName="ACCOUNT_LOGGER",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accountLogSequence")
	@Column(name="CH_ID")
	private Long challangeId;
	@Column(name="CH_TITLE")
	private String challangeName;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="CAT_ID")
	private Category category;
	@OneToMany(fetch = FetchType.EAGER,targetEntity=ChallangeResults.class,mappedBy="challange")	
	private List<ChallangeResults> challangeResults;
	
	
	
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<ChallangeResults> getChallangeResults() {
		return challangeResults;
	}
	public void setChallangeResults(List<ChallangeResults> challangeResults) {
		this.challangeResults = challangeResults;
	}
	
	
	
	
	
}
