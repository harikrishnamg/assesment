package com.dhanjyoti.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DHANJYOTI_ACCOUNT_LOG")
public class AccountLog {
    @Id
    @SequenceGenerator(name="accountLogSequence",sequenceName="ACCOUNT_LOGGER",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accountLogSequence")
   
    @Column(name="LOG_ID")
    private Integer logID;
    
    @Column(name="ACCOUNT")
	private Long account;
    
	@Column(name="CREDIT")    
    private Double creditAmount;
    @Column(name="DEBIT")
    private Double debitAmount;
    @Column(name="LOG_DATE")
    private Date logDate;
    
   
	
	public Integer getLogID() {
		return logID;
	}
	public void setLogID(Integer logID) {
		this.logID = logID;
	}
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	public Double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public Double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	
	
	
}
