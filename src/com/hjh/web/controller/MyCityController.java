package com.hjh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.web.model.MyCity;
import com.hjh.web.service.MyCityService;

@Controller
public class MyCityController{

	@Autowired
	private MyCityService myCityService;
	public void setMyCityService(MyCityService myCityService) {
		this.myCityService = myCityService;
	}
	
	@RequestMapping("/getPro.do")
	public String getProvince(ModelMap map) {
		List<MyCity> pros = myCityService.getProvince();
		System.out.println(pros.size());
		map.addAttribute("pros",pros);
		return "forward:/mycity.jsp";
	}
	
	@RequestMapping("/getCity.do")
	public String getCity(int id,ModelMap map) {
		List<MyCity> pros = myCityService.getProvince();
		List<MyCity> cities = myCityService.getCity(id);
		System.out.println(pros.size());
		System.out.println(cities.size());
		map.addAttribute("proId",id);
		map.addAttribute("pros",pros);
		map.addAttribute("cities",cities);
		return "forward:/mycity.jsp";
	}
	
	@RequestMapping("/getArea.do")
	public String getArea(int proId,int cityId,ModelMap map) {
		List<MyCity> pros = myCityService.getProvince();
		List<MyCity> cities = myCityService.getCity(proId);
		List<MyCity> areas = myCityService.getCity(cityId);
		System.out.println(pros.size());
		System.out.println(cities.size());
		System.out.println(areas.size());
		map.addAttribute("pros",pros);
		map.addAttribute("cities",cities);
		map.addAttribute("areas",areas);
		return "forward:/mycity.jsp";
	}
}
