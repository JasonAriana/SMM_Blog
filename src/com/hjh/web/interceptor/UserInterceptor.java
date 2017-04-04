package com.hjh.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hjh.web.model.User;

public class UserInterceptor extends HandlerInterceptorAdapter{

	private static final String[] LOGIN_URL = {"/login.jsp", "/login.do", "/register.jsp", "/register.do", "images/", 
			"/getNewPost.do", "/aboutus.do", "/logout.do", "/viewPost.do", "/"};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = false;
		HttpSession session = request.getSession();
		String url = request.getRequestURL().toString();
		System.out.println(">>>"+url);
		for(String s : LOGIN_URL){
			if(url.contains(s)){
				flag = true;
				break;
			}
		}
		if(!flag){
			User user = (User)session.getAttribute("userinfo");
			if(user != null){
				flag = true;
			}
		}
		return flag;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
}
