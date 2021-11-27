package com.tutorial.Dao;

import java.util.List;

import com.tutorial.Model.UserAccount;

public interface UserDaoInterface{
	
	void addMember(UserAccount userAccount);
	
	List<UserAccount> findAll();

	List<UserAccount> findByPhone(String phone);

	void updateMember(UserAccount userAccount); 
}