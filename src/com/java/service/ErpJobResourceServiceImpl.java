package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpJobResource;
import com.java.mapper.ErpJobResourceMapper;

public class ErpJobResourceServiceImpl implements ErpJobResourceService{

	@Autowired
	private ErpJobResourceMapper erpJobResourceMapper;
	
	public boolean add(ErpJobResource t) {
		
		return erpJobResourceMapper.add(t);
	}

	public void delete(String id) {
		erpJobResourceMapper.delete(id);
		
	}

	public void update(ErpJobResource t) {
		erpJobResourceMapper.update(t);
	}

	public List<ErpJobResource> getAll(String con) {
		
		return erpJobResourceMapper.getAll(con);
	}

	public ErpJobResource getById(String id) {
		
		return erpJobResourceMapper.getById(id);
	}

	public List<ErpJobResource> getByJob_id(String jobId) {
		
		return erpJobResourceMapper.getByJob_id(jobId);
	}

}
