package com.hjh.web.dao;

import java.util.List;

import com.hjh.web.model.User;

public interface UserDao {

	public List<User> getList();
	public int add(User user);
	public int update(User user);
	public int delete(String id);
	public User getUserById(String id);
	public User getUserByName(String id);
}
