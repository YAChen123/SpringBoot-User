package com.tutorial.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.tutorial.Dao.UserRepository;
import com.tutorial.Model.UserAccount;



@Controller
public class UserApiController{
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/user")
	public String viewHomePage() {
		return "index";
	}
	
	
	//Add User
	@GetMapping("/user/add")
	public String addMember(Model model1) {
		model1.addAttribute("user", new UserAccount());
		return "add";
	}
	
	//Add user Success POST
	@PostMapping("/user/process_register")
	public String processRegisteration(UserAccount user) {
		repo.save(user);
		return "register_success";
	}
	
	//A List of All User
	//@Cacheable("UserAccount")
	@GetMapping("/user/list_users")
	public String viewUserList(Model model1) {
		List<UserAccount> listUsers = repo.findAll();
			model1.addAttribute("listUsers", listUsers);
		return "users";
	}
	
//	@GetMapping("/user/page/{phone}")
//	public String getUser(@PathVariable("phone") String phone, Model model1) {
//		List<UserAccount> findUser = repo.findByPhone(phone);
//		model1.addAttribute("findUser",findUser);
//		//System.out.println(findUser.get(0).getUser_account());
//		return "findUser";
//	}
	
	//Search User by enter Phone Number
	@GetMapping("/user/page")
	public String page(Model model1, @Param("keyword") String keyword) {
		List<UserAccount> listUsers = repo.findByPhone(keyword);
		model1.addAttribute("listUsers", listUsers);
		model1.addAttribute("keyword", keyword);
		return "page";
	}
	
	//Update using get and post
	@GetMapping("/user/update")
	public String update(Model model1, UserAccount user, @Param("keyword") String keyword) {
		model1.addAttribute("user", new UserAccount());
		//List<UserAccount> listUsers = repo.findByPhone(keyword);
		
//		model1.addAttribute("listUsers", listUsers);
//		model1.addAttribute("keyword", keyword);
//		System.out.println(keyword);
//		System.out.println(user.getUser_name());
//		for(int i =0;i<listUsers.size();i++) {
//			UserAccount oldUser = listUsers.get(i);
//			oldUser.setUser_name(user.getUser_name());
//			oldUser.setStatus(user.getStatus());
//			oldUser.setUser_account(user.getUser_account());
//			//oldUser.setPhone(user.getPhone());
//			repo.save(oldUser);
//		}
		return "update";
	}
	
	@PostMapping("/user/update_success")
	public String updateS(Model model1, UserAccount user, @Param("keyword") String keyword) {
		List<UserAccount> listUsers = repo.findByPhone(user.getPhone());
		for(int i =0;i<listUsers.size();i++) {
			UserAccount oldUser = listUsers.get(i);
			oldUser.setUser_name(user.getUser_name());
			oldUser.setStatus(user.getStatus());
			oldUser.setUser_account(user.getUser_account());
			//oldUser.setPhone(user.getPhone());
			repo.save(oldUser);
		}
		return "update_success";
	}
	
	
	
	
	
	
}