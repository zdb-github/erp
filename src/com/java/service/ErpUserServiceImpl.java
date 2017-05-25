package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpUser;
import com.java.mapper.ErpUserMapper;

public class ErpUserServiceImpl implements ErpUserService{

	@Autowired
	private ErpUserMapper erpUserMapper;
	public boolean add(ErpUser t) {
		return erpUserMapper.add(t);
	}

	public void delete(String id) {
		erpUserMapper.delete(id);
	}

	public List<ErpUser> getAll(String con) {
		return erpUserMapper.getAll(con);
	}

	public ErpUser getById(String id) {
		return erpUserMapper.getById(id);
	}

	public void update(ErpUser t) {
		erpUserMapper.update(t);
	}

}
