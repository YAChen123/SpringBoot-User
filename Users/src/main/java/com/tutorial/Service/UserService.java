package com.tutorial.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tutorial.Dao.UserDao;
import com.tutorial.Model.UserAccount;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//Add Member
	public void addMember(UserAccount userAccount) {
		userDao.addMember(userAccount);
	}
	
	//Find All
	public List<UserAccount> findAll(){
		return userDao.findAll();
	}
	
	//Find by Phone
	public List<UserAccount> findByPhone(String phone) {
		return userDao.findByPhone(phone);
	}
	
	//Find All by Phone
	public Page<UserAccount> findAllByPhone(Pageable page, String phone) {
		return userDao.findAllByPhone(page, phone);
	}
	
	//Update Member
	public void updateMember(UserAccount userAccount) {
		userDao.updateMember(userAccount);
	}
	

}
