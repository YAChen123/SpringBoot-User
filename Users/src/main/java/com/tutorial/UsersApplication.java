package com.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;	

@SpringBootApplication
public class UsersApplication  {
	
	/*
	 * @Autowired private JdbcTemplate jdbcTemplate;
	 */

	public static void main(String[] args) {
		
		SpringApplication.run(UsersApplication.class, args);
		
		Config config = new Config();
		// use single Redis server
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");
		RedissonClient redisson = Redisson.create(config);
		// perform operations
		RBucket<String> bucket = redisson.getBucket("stringObject");
		bucket.set("Rommel is the object value");
		RMap<String,String> map = redisson.getMap("theMap");
		map.put("mapKey", "Risa is map value");
		String objValue = bucket.get();
		System.out.println("The object value is: " + objValue);
		String mapValue = map.get("mapKey");
		System.out.println("The map value is: " + mapValue);
		redisson.shutdown();
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
