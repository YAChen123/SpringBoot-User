package com.tutorial.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.Model.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Long>{

	List<UserAccount> findByPhone(String phone);

	
}



