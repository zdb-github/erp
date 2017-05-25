package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpGoods;
import com.java.mapper.ErpGoodsMapper;

public class ErpGoodsServiceImpl implements ErpGoodsService{

	@Autowired
	 private ErpGoodsMapper erpGoodsMapper;
	
	public List<ErpGoods> selectGoods(ErpGoods erpGoods) {
		
		return erpGoodsMapper.selectGoods(erpGoods);
	}

	public boolean add(ErpGoods t) {
		
		return erpGoodsMapper.add(t);
	}

	public void delete(String id) {
		erpGoodsMapper.delete(id);
		
	}

	public void update(ErpGoods t) {
		erpGoodsMapper.update(t);
		
	}

	public List<ErpGoods> getAll(String con) {
		
		return erpGoodsMapper.getAll(con);
	}

	public ErpGoods getById(String id) {
		
		return erpGoodsMapper.getById(id);
	}

}
