package com.cardio.ws.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="challange_results")
public class ChallangeResults {
	@Id
	@SequenceGenerator(name="accountLogSequence",sequenceName="ACCOUNT_LOGGER",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accountLogSequence")
	@Column(name="REC_ID")
	private Long recID;
	@Column(name="DAY")
	private String workDay;
	@Column(name="WEIGHT_LOSS")
	private String weightLos;
	@Column(name="CALARIES_BURNED")
	private String calBurn;
	@Column(name="CH_ID")
	private Long chid;
	/*@JsonIgnore
	@ManyToMany
	@JoinColumn(name="CH_ID")
	private List<Challange> challange;*/
	public Long getRecID() {
		return recID;
	}
	public void setRecID(Long recID) {
		this.recID = recID;
	}
	public String getWorkDay() {
		return workDay;
	}
	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}
	public String getWeightLos() {
		return weightLos;
	}
	public void setWeightLos(String weightLos) {
		this.weightLos = weightLos;
	}
	public String getCalBurn() {
		return calBurn;
	}
	public void setCalBurn(String calBurn) {
		this.calBurn = calBurn;
	}
	public Long getChid() {
		return chid;
	}
	public void setChid(Long chid) {
		this.chid = chid;
	}
	
	/*public List<Challange> getChallange() {
		return challange;
	}
	public void setChallange(List<Challange> challange) {
		this.challange = challange;
	}*/
	
	
	
	

}
