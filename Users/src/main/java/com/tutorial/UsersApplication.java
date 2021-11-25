package com.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class UsersApplication  {
	
	/*
	 * @Autowired private JdbcTemplate jdbcTemplate;
	 */

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
	
	/*
	 * @Override public void run(String... args) throws Exception { String sql =
	 * "INSERT INTO UserAccounts (user_id,user_account, user_name, phone, status) "
	 * + "VALUES ('1','andy123@gmail.com', 'andy123','0912345678','0')";
	 * 
	 * int rows = jdbcTemplate.update(sql); if (rows > 0) {
	 * System.out.println("A new row has been inserted."); } }
	 */
}
