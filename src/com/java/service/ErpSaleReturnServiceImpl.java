package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpSaleReturn;
import com.java.mapper.ErpSaleReturnMapper;

public class ErpSaleReturnServiceImpl implements ErpSaleReturnService{

	@Autowired
	private ErpSaleReturnMapper erpSaleReturnMapper;
	
	public List<ErpSaleReturn> selectSaleReturn(ErpSaleReturn erpSaleReturn) {

		return erpSaleReturnMapper.selectSaleReturn(erpSaleReturn);
	}

	public boolean add(ErpSaleReturn e) {

		return erpSaleReturnMapper.add(e);
	}

	public void delete(String id) {

		erpSaleReturnMapper.delete(id);
	}

	public List<ErpSaleReturn> getAll(String con) {

		return erpSaleReturnMapper.getAll(con);
	}

	public ErpSaleReturn getById(String id) {

		return erpSaleReturnMapper.getById(id);
	}

	public void update(ErpSaleReturn e) {

		erpSaleReturnMapper.update(e);
	}

}
