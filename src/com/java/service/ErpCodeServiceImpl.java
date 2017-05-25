package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpCode;
import com.java.mapper.ErpCodeMapper;

public class ErpCodeServiceImpl implements ErpCodeService{

	@Autowired
	private ErpCodeMapper erpCodeMapper;
	public boolean add(ErpCode t) {
		return erpCodeMapper.add(t);
	}

	public void delete(String id) {
		erpCodeMapper.delete(id);
	}

	public List<ErpCode> getAll(String con) {
		return erpCodeMapper.getAll(con);
	}

	public ErpCode getById(String id) {
		return erpCodeMapper.getById(id);
	}

	public void update(ErpCode t) {
		erpCodeMapper.update(t);
	}

	public ErpCode getByKeyAndType(String key, String type) {

		return erpCodeMapper.getByKeyAndType(key, type);
	}

	public List<ErpCode> getByType(String type) {

		return erpCodeMapper.getByType(type);
	}

}
