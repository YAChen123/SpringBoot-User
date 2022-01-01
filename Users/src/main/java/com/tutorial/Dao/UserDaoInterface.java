package com.tutorial.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tutorial.Model.UserAccount;

public interface UserDaoInterface{

	int count(); 
	
	void addMember(UserAccount userAccount);
	
	List<UserAccount> findAll();

	List<UserAccount> findByPhone(String phone);

	void updateMember(UserAccount userAccount);

	Page<UserAccount> findAllByPhone(Pageable page, String phone);

}