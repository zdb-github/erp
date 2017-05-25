package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpSale;
import com.java.mapper.ErpSaleMapper;

public class ErpSaleServiceImpl implements ErpSaleService{

	@Autowired
	private ErpSaleMapper erpSaleMapper;
	
	public List<ErpSale> selectSale(ErpSale erpSale) {

		return erpSaleMapper.selectSale(erpSale);
	}

	public boolean add(ErpSale e) {

		return erpSaleMapper.add(e);
	}

	public void delete(String id) {

		erpSaleMapper.delete(id);
	}

	public List<ErpSale> getAll(String con) {

		return erpSaleMapper.getAll(con);
	}

	public ErpSale getById(String id) {

		return erpSaleMapper.getById(id);
	}

	public void update(ErpSale e) {

		erpSaleMapper.update(e);
	}

}
