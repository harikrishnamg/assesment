package com.dhanjyoti.model;

import org.springframework.web.multipart.MultipartFile;

public class User {
	
	private String userID;
	private String firstName;
	
	private String lastName;
	
	private String dateOfBirth;
	
	private String address1;
	
	private String address2;
	
	private String city;

	private String state;
	
	private String pin;

	private String mobile;
	
	private String email;
	
	private String aadhar;
	
	private String pan;

	private String userName;
	
	private String loginPassword;

	private String confirmPassword;
	
	private Long account;
	private Double balance;
	
	private MultipartFile dobFile;
	private MultipartFile addressFile;
	private MultipartFile aadharFile;
	private MultipartFile panFile;
	
    
	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public MultipartFile getDobFile() {
		return dobFile;
	}

	public void setDobFile(MultipartFile dobFile) {
		this.dobFile = dobFile;
	}

	public MultipartFile getAddressFile() {
		return addressFile;
	}

	public void setAddressFile(MultipartFile addressFile) {
		this.addressFile = addressFile;
	}

	public MultipartFile getAadharFile() {
		return aadharFile;
	}

	public void setAadharFile(MultipartFile aadharFile) {
		this.aadharFile = aadharFile;
	}

	public MultipartFile getPanFile() {
		return panFile;
	}

	public void setPanFile(MultipartFile panFile) {
		this.panFile = panFile;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
}
