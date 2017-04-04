package com.hjh.web.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.web.model.Comment;
import com.hjh.web.model.Post;
import com.hjh.web.model.User;
import com.hjh.web.service.CommentService;
import com.hjh.web.service.PostService;
import com.hjh.web.service.UserService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	@Autowired
	private CommentService commentService;
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/getNewPost.do")
	public String getNewPost(ModelMap map, HttpServletRequest request) {
		List<Post> posts = postService.getListNew();
		List<Integer> comNum = new ArrayList<>();
		for (Post item : posts) {
			int num = commentService.getNumByPostId(item.getId());
			comNum.add(num);
		}
		
		map.addAttribute("posts", posts);
		map.addAttribute("comNum", comNum);
		
		if(request.getSession().getAttribute("userinfo") != null){
			User user = (User) request.getSession().getAttribute("userinfo");
			System.out.println(user.getName());
			map.addAttribute("user", user);
		}

		return "forward:/index.jsp";
	}
	
	@RequestMapping("/getAllPost.do")
	public String getAllPost(ModelMap map, HttpServletRequest request) {
		List<Post> posts = postService.getList();
		List<Integer> comNum = new ArrayList<>();
		for (Post item : posts) {
			int num = commentService.getNumByPostId(item.getId());
			comNum.add(num);
		}
		
		map.addAttribute("posts", posts);
		map.addAttribute("comNum", comNum);
		
		if(request.getSession().getAttribute("userinfo") != null){
			User user = (User) request.getSession().getAttribute("userinfo");
			System.out.println(user.getName());
			map.addAttribute("user", user);
		}
		
		return "forward:/posts.jsp";
	}
	
	@RequestMapping("/addPost.do")
	public String addPost(Post post, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("userinfo");
		if(user== null){
			return "redirect:/login.jsp";
		}
		
//		boolean flag = true;
//		if(post.getTitle() == null && post.getTitle() == ""){
//			flag = false;
//		}else if (post.getContent() == null && post.getContent() == ""){
//			flag = false;			
//		}
//		
//		if(!flag){
//			return "";
//		}else {	
		System.out.println(post.getTitle()+":"+post.getContent());
			post.setId(UUID.randomUUID().toString());
			post.setAuthor(user.getId());
			Timestamp date = new Timestamp(System.currentTimeMillis());
			post.setAddDate(date);
			post.setPv(0);
			postService.addPost(post);
			return "forward:/getAllPost.do";
//		}	
	}
	
	@RequestMapping("/modifyPost.do")
	public String modifyPost(String id, ModelMap map) {
		Post post = postService.getPostById(id);
		if(post == null){
			return "";
		}
		
		map.addAttribute("post", post);
		return "forward:/updatePost.jsp";
	}
	
	@RequestMapping("/updatePost.do")
	public String updatePost(String id,String title, String content) {
		System.out.println(id+":"+title+":"+content);
		Post post = postService.getPostById(id);
		post.setTitle(title);
		post.setContent(content);
		postService.updatePost(post);
		return "forward:/getAllPost.do";
	}
	
	@RequestMapping("/viewPost.do")
	public String viewPost(String id, ModelMap map, HttpServletRequest request) {
		Post post = postService.getPostById(id);
		if(post == null){
			return "";
		}
		
		postService.updatePv(post.getId());
		
		List<Comment> comments = commentService.getListByPostId(post.getId());
		for(Comment comment : comments){
			User user = userService.getUserById(comment.getAuthor());
			comment.setAuthor(user.getName());
		}
		
		User user = (User) request.getSession().getAttribute("userinfo");
		map.addAttribute("post", post);
		map.addAttribute("comments", comments);
		if(user != null){
			map.addAttribute("user", user);
		}else {
			map.addAttribute("user", null);
		}
		
		return "forward:/viewPost.jsp";
	}
	
	@RequestMapping("/deletePost.do")
	public String deletePost(String id) {
		Post post = postService.getPostById(id);
		if(post == null){
			return "";
		}
		
		int res = postService.deletePost(id);
		if(res > 0){
			commentService.deleteCommentbyPostId(id);
			return "forward:/getAllPost.do";
		}
		return "";
	}
	
	@RequestMapping("/userhome.do")
	public String userhome(ModelMap map, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("userinfo");
		if(user == null){
			return "redirect:/login.jsp";
		}
		
		List<Post> posts = postService.getListByAuthor(user.getId());
		List<Integer> comNum = new ArrayList<>();
		for (Post item : posts) {
			int num = commentService.getNumByPostId(item.getId());
			comNum.add(num);
		}
		map.addAttribute("posts", posts);
		map.addAttribute("comNum", comNum);
		map.addAttribute("user", user);

		return "forward:/userhome.jsp";
	}
	
	@RequestMapping("toAddPost.do")
	public String toAddPost(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("userinfo");
		if(user == null){
			return "redirect:/login.jsp";
		}
		
		return "redirect:/addPost.jsp";
	}
}
