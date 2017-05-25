package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpGoodsSale;
import com.java.mapper.ErpGoodsSaleMapper;
/*
 * 商品销量
 * 
 */
public class ErpGoodsSaleServiceImpl implements ErpGoodsSaleService {
	
	@Autowired
	private ErpGoodsSaleMapper erpGoodsSaleMapper;
	public boolean add(ErpGoodsSale t) {
		
		return erpGoodsSaleMapper.add(t);
	}

	public void delete(String id) {
	
		erpGoodsSaleMapper.delete(id);

	}

	public List<ErpGoodsSale> getAll(String con) {
		
		return erpGoodsSaleMapper.getAll(con);
	}

	public ErpGoodsSale getById(String id) {
		
		return erpGoodsSaleMapper.getById(id);
	}

	public void update(ErpGoodsSale t) {
		
		erpGoodsSaleMapper.update(t);

	}

}
