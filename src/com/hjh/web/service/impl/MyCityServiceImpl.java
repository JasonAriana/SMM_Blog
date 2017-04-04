package com.hjh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjh.web.dao.MyCityDao;
import com.hjh.web.model.MyCity;
import com.hjh.web.service.MyCityService;

@Service("myCityService")
public class MyCityServiceImpl implements MyCityService{

	@Autowired
	private MyCityDao myCityDao;
	public void setMyCityDao(MyCityDao myCityDao) {
		this.myCityDao = myCityDao;
	}
	
	@Override
	public List<MyCity> getProvince() {
		return myCityDao.getProvince();
	}
	
	@Override
	public List<MyCity> getCity(int id) {
		return myCityDao.getCity(id);
	}
}
