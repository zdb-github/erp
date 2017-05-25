package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpResource;
import com.java.mapper.ErpResourceMapper;

public class ErpResourceServiceImpl implements ErpResourceService{

	@Autowired
	private ErpResourceMapper erpResourceMapper;
	
	public boolean add(ErpResource t) {
		
		return erpResourceMapper.add(t);
	}

	public void delete(String id) {
		erpResourceMapper.delete(id);
		
	}

	public void update(ErpResource t) {
		erpResourceMapper.update(t);
		
	}

	public List<ErpResource> getAll(String con) {
		
		return erpResourceMapper.getAll(con);
	}

	public ErpResource getById(String id) {
		
		return erpResourceMapper.getById(id);
	}

	public List<ErpResource> selectResource(ErpResource erpResource) {
		
		return erpResourceMapper.selectResource(erpResource);
	}

	public ErpResource getByDo_path(String do_path) {
		
		return erpResourceMapper.getByDo_path(do_path);
	}

	public List<ErpResource> getByRole_type(String role_type) {

		return erpResourceMapper.getByRole_type(role_type);
	}

}
