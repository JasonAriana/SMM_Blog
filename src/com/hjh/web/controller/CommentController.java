package com.hjh.web.controller;

import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.web.model.Comment;
import com.hjh.web.model.User;
import com.hjh.web.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@RequestMapping("/addComment.do")
	public String addComment(String content, String postId, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("userinfo");
		if(user == null){
			return "";
		}
		System.out.println(content+":"+postId);
		Comment comment = new Comment();
		comment.setId(UUID.randomUUID().toString());
		comment.setContent(content);		
		comment.setAuthor(user.getId());
		Timestamp date = new Timestamp(System.currentTimeMillis());
		comment.setAddDate(date);
		comment.setPostId(postId);
		commentService.addComment(comment);
		return "forward:/viewPost.do?id="+postId;
	}
	
	@RequestMapping("/deleteComment.do")
	public String deleteComment(String id) {
		Comment comment = commentService.getCommentById(id);
		if(comment == null){
			return "";
		}
		
		String postId = comment.getPostId();
		int res = commentService.deleteComment(id);
		if(res > 0){
			return "forward:/viewPost.do?id="+postId;
		}
		return "forward:/viewPost.do?id="+postId;
	}
}
