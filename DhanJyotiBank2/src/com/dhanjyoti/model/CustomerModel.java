package com.dhanjyoti.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="DHANJYOTI_CUSTOMER")
public class CustomerModel {
	@Id
	 @SequenceGenerator(name="customerSequence",sequenceName="CUSTOMER_SEQUENCE",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customerSequence")
	
	@Column(name="CUSTOMER_ID")
	private Integer customerID;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	@Column(name="ADDRESS_LINE1")
	private String address1;
	@Column(name="ADDRESS_LINE2")
	private String address2;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="PIN")
	private String pin;
	@Column(name="MOBILE")
	private String mobile;
	@Column(name="EMAIL")
	private String email;
	@Column(name="AADHAR")
	private String aadhar;
	@Column(name="PAN")
	private String pan;
	@Column(name="LOGIN_USER_NAME")
	private String userName;
	@Column(name="LOGIN_PASSWORD")
	private String loginPassword;
	@Column(name="STATUS")
	private String customerStat;
	@OneToMany(targetEntity=CustomerKypDocs.class, mappedBy="customer",cascade = CascadeType.ALL,fetch=FetchType.EAGER)	
	private List<CustomerKypDocs> customerDocs;
	
	
	
	public List<CustomerKypDocs> getCustomerDocs() {
		return customerDocs;
	}

	public void setCustomerDocs(List<CustomerKypDocs> customerDocs) {
		this.customerDocs = customerDocs;
	}

	public String getCustomerStat() {
		return customerStat;
	}

	public void setCustomerStat(String customerStat) {
		this.customerStat = customerStat;
	}


	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	
	
}
