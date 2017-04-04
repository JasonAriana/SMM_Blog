package com.hjh.web.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hjh.web.dao.UserDao;
import com.hjh.web.model.User;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO 自动生成的方法存根
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<User> getList() {
		return getSqlSession().selectList("com.hjh.web.model.UserMapper.getList");
	}
	
	@Override
	public int add(User user) {
		return getSqlSession().insert("com.hjh.web.model.UserMapper.addUser", user);
	}
	
	@Override
	public User getUserById(String id) {
		return getSqlSession().selectOne("com.hjh.web.model.UserMapper.getUserById", id);
	}
	
	@Override
	public User getUserByName(String name) {
		return getSqlSession().selectOne("com.hjh.web.model.UserMapper.getUserByName", name);
	}
	
	@Override
	public int update(User user) {
		return getSqlSession().update("com.hjh.web.model.UserMapper.updateUser", user);
	}

	@Override
	public int delete(String id) {
		return getSqlSession().delete("com.hjh.web.model.UserMapper.delete", id);
	}

}
