package com.dhanjyoti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DHANJYOTI_BANK_USER")
public class BankUserModel {
    @Id
    @Column(name="USER_ID")
	private Integer userId;
    @Column(name="ROLE")
	private String role;
    @Column(name="LOGIN_ID")
	private String loginId;
    @Column(name="LOGIN_PASSWORD")
	private String loginPwd;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
    
    
	
}
