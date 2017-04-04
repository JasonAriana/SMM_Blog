package com.hjh.web.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hjh.web.dao.PostDao;
import com.hjh.web.model.Post;

@Repository("postDao")
public class PostDaoImpl extends SqlSessionDaoSupport implements PostDao{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<Post> getList() {
		return getSqlSession().selectList("com.hjh.web.model.PostMapper.getList");
	}
	
	@Override
	public List<Post> getListNew() {
		return getSqlSession().selectList("com.hjh.web.model.PostMapper.getListNew");
	}

	@Override
	public List<Post> getListByAuthor(String author) {
		return getSqlSession().selectList("com.hjh.web.model.PostMapper.getListByAuthor", author);
	}

	@Override
	public int addPost(Post post) {
		return getSqlSession().insert("com.hjh.web.model.PostMapper.addPost", post);
	}

	@Override
	public int updatePost(Post post) {
		return getSqlSession().update("com.hjh.web.model.PostMapper.updatePost", post);
	}

	@Override
	public int deletePost(String id) {
		return getSqlSession().delete("com.hjh.web.model.PostMapper.deletePost", id);
	}

	@Override
	public Post getPostById(String id) {
		return getSqlSession().selectOne("com.hjh.web.model.PostMapper.getPostById", id);
	}

	@Override
	public int updatePv(String id) {
		return getSqlSession().update("com.hjh.web.model.PostMapper.updatePv", id);
	}
}
