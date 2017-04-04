package com.hjh.web.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hjh.web.dao.MyCityDao;
import com.hjh.web.model.MyCity;

@Repository("myCityDao")
public class MyCityDaoImpl extends SqlSessionDaoSupport implements MyCityDao{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<MyCity> getProvince() {
		return getSqlSession().selectList("com.hjh.web.model.MyCityMapper.getProvince");
	}

	@Override
	public List<MyCity> getCity(int id) {
		return getSqlSession().selectList("com.hjh.web.model.MyCityMapper.getCity", id);
	}

}
