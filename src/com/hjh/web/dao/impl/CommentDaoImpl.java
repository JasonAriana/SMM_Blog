package com.hjh.web.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hjh.web.dao.CommentDao;
import com.hjh.web.model.Comment;

@Repository("commentDao")
public class CommentDaoImpl extends SqlSessionDaoSupport implements CommentDao{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<Comment> getList() {
		return getSqlSession().selectList("com.hjh.web.model.CommentMapper.getList");
	}

	@Override
	public List<Comment> getListByPostId(String postId) {
		return getSqlSession().selectList("com.hjh.web.model.CommentMapper.getListByPostId", postId);
	}
	
	@Override
	public int getNumByPostId(String postId) {
		return getSqlSession().selectOne("com.hjh.web.model.CommentMapper.getNumByPostId", postId);
	}

	@Override
	public int addComment(Comment comment) {
		return getSqlSession().insert("com.hjh.web.model.CommentMapper.addComment", comment);
	}

	@Override
	public int updateComment(Comment comment) {
		return getSqlSession().update("com.hjh.web.model.CommentMapper.updateComment", comment);
	}

	@Override
	public int deleteComment(String id) {
		return getSqlSession().delete("com.hjh.web.model.CommentMapper.deleteComment", id);
	}

	@Override
	public Comment getCommentById(String id) {
		return getSqlSession().selectOne("com.hjh.web.model.CommentMapper.getCommentById", id);
	}

	@Override
	public int deleteCommentbyPostId(String postId) {
		return getSqlSession().delete("com.hjh.web.model.CommentMapper.deleteCommentByPostId", postId);
	}

}
