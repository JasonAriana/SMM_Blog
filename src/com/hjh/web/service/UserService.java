package com.hjh.web.service;

import java.util.List;

import com.hjh.web.model.User;

public interface UserService {

	public List<User> getList();
	public int add(User user);
	public int update(User user);
	public int delete(String id);
	public User getUserById(String id);
	public User getUserByName(String name);
}
