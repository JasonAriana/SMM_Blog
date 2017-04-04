package com.hjh.web.dao;

import java.util.List;

import com.hjh.web.model.MyCity;

public interface MyCityDao {
	public List<MyCity> getProvince();
	public List<MyCity> getCity(int id);
}
