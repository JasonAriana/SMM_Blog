package com.hjh.web.dao;

import java.util.List;

import com.hjh.web.model.Post;

public interface PostDao {

	public List<Post> getList();
	public List<Post> getListNew();
	public List<Post> getListByAuthor(String author);
	public int addPost(Post post);
	public int updatePost(Post post);
	public int deletePost(String id);
	public Post getPostById(String id);
	public int updatePv(String id);
}
