package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpJobUser;
import com.java.mapper.ErpJobUserMapper;

public class ErpJobUserServiceImpl implements ErpJobUserService{

	@Autowired
	private ErpJobUserMapper erpJobUserMapper;
	
	
	public boolean add(ErpJobUser t) {
		
		return erpJobUserMapper.add(t);
	}

	public void delete(String id) {
		erpJobUserMapper.delete(id);
		
	}

	public void update(ErpJobUser t) {
		erpJobUserMapper.update(t);
		
	}

	public List<ErpJobUser> getAll(String con) {
		
		return erpJobUserMapper.getAll(con);
	}

	public ErpJobUser getById(String id) {
	
		return erpJobUserMapper.getById(id);
	}

	public ErpJobUser getByUser_id(String userId) {
		
		return erpJobUserMapper.getByUser_id(userId);
	}

}
