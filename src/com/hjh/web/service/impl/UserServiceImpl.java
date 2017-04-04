package com.hjh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjh.web.dao.UserDao;
import com.hjh.web.model.User;
import com.hjh.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<User> getList() {
		return userDao.getList();
	}
	
	@Override
	public int add(User user) {
		return userDao.add(user);
	}
	
	@Override
	public User getUserById(String id) {
		return userDao.getUserById(id);
	}
	
	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}
	
	@Override
	public int update(User user) {
		return userDao.update(user);
	}
	
	@Override
	public int delete(String id) {
		return userDao.delete(id);
	}

}
