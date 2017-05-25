package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpPurchaseOrder;
import com.java.mapper.ErpPurchaseOrderMapper;

public class ErpPurchaseOrderServiceImpl implements ErpPurchaseOrderService{

	@Autowired
	private ErpPurchaseOrderMapper erpPurchaseOrderMapper;

	public boolean add(ErpPurchaseOrder e) {

		return erpPurchaseOrderMapper.add(e);
	}

	public void delete(String id) {

		erpPurchaseOrderMapper.delete(id);
	}

	public List<ErpPurchaseOrder> getAll(String con) {

		return erpPurchaseOrderMapper.getAll(con);
	}

	public ErpPurchaseOrder getById(String id) {

		return erpPurchaseOrderMapper.getById(id);
	}

	public void update(ErpPurchaseOrder e) {

		erpPurchaseOrderMapper.update(e);
	}

	public List<ErpPurchaseOrder> selectPo(ErpPurchaseOrder erpPuchaseOrder) {

		return erpPurchaseOrderMapper.selectPo(erpPuchaseOrder);
	}
	
	

	
}
