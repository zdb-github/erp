package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpReply;
import com.java.mapper.ErpReplyMapper;

public class ErpReplyServiceImpl implements ErpReplyService{

	@Autowired
	private ErpReplyMapper erpReplyMapper;
	public boolean add(ErpReply t) {
		return erpReplyMapper.add(t);
	}

	public void delete(String id) {
		erpReplyMapper.delete(id);
	}

	public List<ErpReply> getAll(String con) {
		return erpReplyMapper.getAll(con);
	}

	public ErpReply getById(String id) {
		return erpReplyMapper.getById(id);
	}

	public void update(ErpReply t) {
		erpReplyMapper.update(t);
	}

}
