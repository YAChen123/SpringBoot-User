package com.tutorial.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tutorial.Model.UserAccount;

@Repository
public class UserDao implements UserDaoInterface, RowMapper<UserAccount> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {

		// 1. Getting Data from Result
		int id = rs.getInt("user_id");
		String user_account = rs.getString("user_account");
		String user_name = rs.getString("user_name");
		String phone = rs.getString("phone");
		int status = rs.getInt("status");

		// 2. Data to Object
		UserAccount user = new UserAccount();
		user.setUser_id(id);
		user.setUser_account(user_account);
		user.setUser_name(user_name);
		user.setPhone(phone);
		user.setStatus(status);
		return user;
	}

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("SELECT count(*) FROM user_accounts", Integer.class);
	}

	@Override
	public void addMember(UserAccount userAccount) {
		System.out.println("EXCUTE INSERT MEMBER");
		String sql = "INSERT INTO user_accounts(user_account, user_name, phone,status) " + "VALUES (?,?,?,?)";

		int result = jdbcTemplate.update(sql, userAccount.getUser_account(), userAccount.getUser_name(),
				userAccount.getPhone(), userAccount.getStatus());

		if (result > 0) {
			System.out.println("A new row has been inserted");
		}
	}

	@Override
	public List<UserAccount> findAll() {
		String sql = "SELECT * FROM user_accounts";
		System.out.println("EXCUTE Find All User");
		return jdbcTemplate.query(sql, new UserDao());

	}

	@Override
	public List<UserAccount> findByPhone(String phone) {
		String sql = "SELECT * FROM user_accounts WHERE phone = ?";
		List<UserAccount> user = jdbcTemplate.query(sql, new UserDao(), phone);
		System.out.println("EXCUTE Find User with: " + phone);
		return user;

	}

	@Override
	public Page<UserAccount> findAllByPhone(Pageable page, String phone) {
		Order order = !page.getSort().isEmpty() ? page.getSort().toList().get(0) : Order.by("status");
		List<UserAccount> users = jdbcTemplate.query("SELECT * FROM user_accounts WHERE phone = '" + phone + "' ORDER BY " + order.getProperty() + " "
				+ order.getDirection().name() + " LIMIT " + page.getPageSize() + " OFFSET " + page.getOffset(),
				(rs, rowNum) -> mapRow(rs, rowNum));
		return new PageImpl<UserAccount>(users, page, count());
	}

	@Override
	public void updateMember(UserAccount userAccount) {
		String sql = "UPDATE user_accounts set user_account = ? , user_name = ? , status = ? WHERE phone = ?";
		int result = jdbcTemplate.update(sql, userAccount.getUser_account(), userAccount.getUser_name(),
				userAccount.getStatus(), userAccount.getPhone());

		if (result > 0) {
			System.out.println("A user has been updated with phone number: " + userAccount.getPhone());
		}

	}

}