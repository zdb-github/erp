package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpPurchase;
import com.java.mapper.ErpPurchaseMapper;

public class ErpPurchaseServiceImpl implements ErpPurchaseService{

	@Autowired
	private ErpPurchaseMapper erpPurchaseMapper;
	
	public List<ErpPurchase> selectPurchase(ErpPurchase erpPurchase) {

		return erpPurchaseMapper.selectPurchase(erpPurchase);
	}

	public boolean add(ErpPurchase e) {

		return erpPurchaseMapper.add(e);
	}

	public void delete(String id) {

		erpPurchaseMapper.delete(id);
	}

	public List<ErpPurchase> getAll(String con) {

		return erpPurchaseMapper.getAll(con);
	}

	public ErpPurchase getById(String id) {

		return erpPurchaseMapper.getById(id);
	}

	public void update(ErpPurchase e) {

		erpPurchaseMapper.update(e);
	}

}
