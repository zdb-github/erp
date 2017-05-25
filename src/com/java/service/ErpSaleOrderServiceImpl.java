package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpSaleOrder;
import com.java.mapper.ErpSaleOrderMapper;

public class ErpSaleOrderServiceImpl implements ErpSaleOrderService{

	@Autowired
	private ErpSaleOrderMapper erpSaleOrderMapper;
	
	public List<ErpSaleOrder> selectSaleOrder(ErpSaleOrder erpSaleOrder) {

		return erpSaleOrderMapper.selectSaleOrder(erpSaleOrder);
	}

	public boolean add(ErpSaleOrder e) {

		return erpSaleOrderMapper.add(e);
	}

	public void delete(String id) {

		erpSaleOrderMapper.delete(id);
	}

	public List<ErpSaleOrder> getAll(String con) {

		return erpSaleOrderMapper.getAll(con);
	}

	public ErpSaleOrder getById(String id) {

		return erpSaleOrderMapper.getById(id);
	}

	public void update(ErpSaleOrder e) {

		erpSaleOrderMapper.update(e);
	}

}
