package com.hjh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjh.web.dao.PostDao;
import com.hjh.web.model.Post;
import com.hjh.web.service.PostService;

@Service("postService")
public class PostServiceImpl implements PostService{

	@Autowired
	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	@Override
	public List<Post> getList() {
		return postDao.getList();
	}
	
	@Override
	public List<Post> getListNew() {
		return postDao.getListNew();
	}

	@Override
	public List<Post> getListByAuthor(String author) {
		return postDao.getListByAuthor(author);
	}

	@Override
	public int addPost(Post post) {
		return postDao.addPost(post);
	}

	@Override
	public int updatePost(Post post) {
		return postDao.updatePost(post);
	}

	@Override
	public int deletePost(String id) {
		return postDao.deletePost(id);
	}

	@Override
	public Post getPostById(String id) {
		return postDao.getPostById(id);
	}

	@Override
	public int updatePv(String id) {
		return postDao.updatePv(id);
	}

}
