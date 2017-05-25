package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpJob;
import com.java.mapper.ErpJobMapper;

public class ErpJobServiceImpl implements ErpJobService{

	@Autowired
	private ErpJobMapper erpJobMapper;
	
	public boolean add(ErpJob t) {
		
		return erpJobMapper.add(t);
	}

	public void delete(String id) {
		erpJobMapper.delete(id);
		
	}

	public void update(ErpJob t) {
		erpJobMapper.update(t);
		
	}

	public List<ErpJob> getAll(String con) {
		
		return erpJobMapper.getAll(con);
	}

	public ErpJob getById(String id) {
		
		return erpJobMapper.getById(id);
	}

}
