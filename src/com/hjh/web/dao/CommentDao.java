package com.hjh.web.dao;

import java.util.List;

import com.hjh.web.model.Comment;

public interface CommentDao {

	public List<Comment> getList();
	public List<Comment> getListByPostId(String postId);
	public int getNumByPostId(String postId);
	public int addComment(Comment comment);
	public int updateComment(Comment comment);
	public int deleteComment(String id);
	public Comment getCommentById(String id);
	public int deleteCommentbyPostId(String postId);
}
