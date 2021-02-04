package com.dhanjyoti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="DHANJYOTI_ACCOUNT_TABLE")
public class Account {
	    @Id	    
	    @SequenceGenerator(name="accountSequence",sequenceName="ACCOUNT_CREATION",allocationSize=1)
	    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="accountSequence")
	    @Column(name="ACCOUNT")
		private Long account;
	    @Column(name="CUSTOMER_ID")
		private Integer customerID;
	    @Column(name="BALANCE")
		private Double balance;
	    @Column(name="MOBILE")
		private String mobile;
	    @Column(name="ACCOUNT_STATUS")
		private String accStatus;
		
		public Long getAccount() {
			return account;
		}
		public void setAccount(Long account) {
			this.account = account;
		}
		public Integer getCustomerID() {
			return customerID;
		}
		public void setCustomerID(Integer customerID) {
			this.customerID = customerID;
		}
		public Double getBalance() {
			return balance;
		}
		public void setBalance(Double balance) {
			this.balance = balance;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String string) {
			this.mobile = string;
		}
		public String getAccStatus() {
			return accStatus;
		}
		public void setAccStatus(String accStatus) {
			this.accStatus = accStatus;
		}
	    
}
