package com.hjh.web.service;

import java.util.List;

import com.hjh.web.model.MyCity;

public interface MyCityService {

	public List<MyCity> getProvince();
	public List<MyCity> getCity(int id);
}
