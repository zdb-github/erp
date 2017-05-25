package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpDept;
import com.java.mapper.ErpDeptMapper;

public class ErpDeptServiceImpl implements ErpDeptService{

	@Autowired
	private ErpDeptMapper erpDeptMapper;
	public boolean add(ErpDept t) {
		
		return erpDeptMapper.add(t);
	}

	public void delete(String id) {
		erpDeptMapper.delete(id);
		
	}

	public void update(ErpDept t) {
		erpDeptMapper.update(t);
	}

	public List<ErpDept> getAll(String con) {
		
		return erpDeptMapper.getAll(con);
	}

	public ErpDept getById(String id) {
		
		return erpDeptMapper.getById(id);
	}

	public List<ErpDept> selectDept(ErpDept erpDetp) {
		
		return erpDeptMapper.selectDept(erpDetp);
	}

}
