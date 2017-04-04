package com.hjh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjh.web.dao.CommentDao;
import com.hjh.web.model.Comment;
import com.hjh.web.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	@Override
	public List<Comment> getList() {
		return commentDao.getList();
	}

	@Override
	public List<Comment> getListByPostId(String postId) {
		return commentDao.getListByPostId(postId);
	}
	
	@Override
	public int getNumByPostId(String postId) {
		return commentDao.getNumByPostId(postId);
	}

	@Override
	public int addComment(Comment comment) {
		return commentDao.addComment(comment);
	}

	@Override
	public int updateComment(Comment comment) {
		return commentDao.updateComment(comment);
	}

	@Override
	public int deleteComment(String id) {
		return commentDao.deleteComment(id);
	}

	@Override
	public Comment getCommentById(String id) {
		return commentDao.getCommentById(id);
	}

	@Override
	public int deleteCommentbyPostId(String postId) {
		return commentDao.deleteCommentbyPostId(postId);
	}

}
