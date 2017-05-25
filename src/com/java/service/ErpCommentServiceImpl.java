package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpComment;
import com.java.mapper.ErpCommentMapper;

public class ErpCommentServiceImpl implements ErpCommentService{

	@Autowired
	private ErpCommentMapper erpCommentMapper;
	public boolean add(ErpComment t) {
		return erpCommentMapper.add(t);
	}

	public void delete(String id) {
		erpCommentMapper.delete(id);
	}

	public List<ErpComment> getAll(String con) {
		return erpCommentMapper.getAll(con);
	}

	public ErpComment getById(String id) {
		return erpCommentMapper.getById(id);
	}

	public void update(ErpComment t) {
		erpCommentMapper.update(t);
	}

}
