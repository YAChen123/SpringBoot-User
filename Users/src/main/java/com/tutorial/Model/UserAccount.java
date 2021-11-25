package com.tutorial.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserAccounts")

public class UserAccount{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long user_id;
	
	@Column(name="user_account")
	private String user_account;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="status")
	private int status;
	
	
	public UserAccount() {
		
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "UserAccount [user_id=" + user_id + ", user_account=" + user_account + ", user_name=" + user_name
				+ ", phone=" + phone + ", status=" + status + "]";
	}
}

