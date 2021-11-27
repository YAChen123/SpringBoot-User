//package com.tutorial;
//
//import static org.junit.Assert.*;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import com.tutorial.Dao.UserRepository;
//import com.tutorial.Model.UserAccount;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//
//public class UserRepositoryTests {
//	
//	@Autowired
//	private UserRepository repo;
//	
//	@Autowired
//	private TestEntityManager entityManager;
//	
//	
//	@Test
//	public void testCreateUser() {
//		
//		UserAccount user = new UserAccount();
//		user.setUser_id(2);
//		user.setUser_account("andy@gmail.com");
//		user.setUser_name("Andy");
//		user.setPhone("0912345678");
//		user.setStatus(1);
//  		
//		UserAccount saveUser = repo.save(user);
//		
//		UserAccount existUser = entityManager.find(UserAccount.class, saveUser.getUser_id());
//		
//		assertThat(existUser.getUser_account()).isEqualTo(user.getUser_account());
//		
//		
//	}
//
//}
