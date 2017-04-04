package com.hjh.web.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.web.model.User;
import com.hjh.web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/list.do")
	public String list(ModelMap map) {
		List<User> list = userService.getList();
		map.addAttribute("list",list);
		return "forward:/list.jsp";
	}
	
	@RequestMapping("/register.do")
	public String register(User user) {
		System.out.println(user.getName());
		user.setId(UUID.randomUUID().toString());
		String pass = DigestUtils.sha1Hex(user.getPassword());
		user.setPassword(pass);	
		int res = userService.add(user);
		if(res>0){
			return "redirect:/login.jsp";
		}
		return "redirect:/register.jsp";
	}
	
	@RequestMapping("/login.do")
	public String login(String name, String password, HttpServletRequest request) {
		try{
			HttpSession session = request.getSession();
			User user = userService.getUserByName(name);
			if(user != null){
				if(user.getPassword().equals(DigestUtils.sha1Hex(password))){
					session.setAttribute("userinfo", user);
					return "forward:/getNewPost.do";
				}else{
					return "redirect:/login.jsp";
				}				
			}else{
				return "redirect:/login.jsp";
			}
			
		}catch (Exception e) {
			return "redirect:/login.jsp";
		}
	}
	
	@RequestMapping("/modify.do")
	public String modify(String id, ModelMap map){
		try{
			User user = userService.getUserById(id);
			System.out.println(user.getId()+","+user.getName());
			map.addAttribute("user", user);
			return "forward:/update.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			return "redirect:/update.jsp";
		}
	}
	
	@RequestMapping("/update.do")
	public String update(User user) {
		System.out.println(user.getId()+","+user.getName());
		int res = userService.update(user);
		if(res>0){
			return "redirect:/list.do";
		}
		return"redirect:/update.jsp";
	}
	
	@RequestMapping("/delete.do")
	public String delete(String id) {
		if(userService.delete(id) > 0){
			return "redirect:/list.do";
		}
		return "redirect:/error.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userinfo");
		return "redirect:/getNewPost.do";
	}
	
	@RequestMapping("/aboutus.do")
	public String aboutus(ModelMap map) {
		map.addAttribute("blogtitle","Jason's Blog");
		map.addAttribute("bloguse", "使用了SpringMVC、Spring、Mybatis框架，MySQL数据库");
		return "forward:/aboutus.jsp";
	}
}
