package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpCustomer;
import com.java.mapper.ErpCustomerMapper;

public class ErpCustomerServiceImpl implements ErpCustomerService{

	@Autowired
	private ErpCustomerMapper erpCustomerMapper;
	public boolean add(ErpCustomer t) {
		return erpCustomerMapper.add(t);
	}

	public void delete(String id) {
		erpCustomerMapper.delete(id);
	}

	public List<ErpCustomer> getAll(String con) {
		return erpCustomerMapper.getAll(con);
	}

	public ErpCustomer getById(String id) {
		return erpCustomerMapper.getById(id);
	}

	public void update(ErpCustomer t) {
		erpCustomerMapper.update(t);
	}

}
