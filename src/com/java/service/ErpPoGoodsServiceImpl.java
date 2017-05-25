package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpPoGoods;
import com.java.mapper.ErpPoGoodsMapper;

public class ErpPoGoodsServiceImpl implements ErpPoGoodsService{

	@Autowired
	private ErpPoGoodsMapper erpPoGoodsMapper;
	
	public List<ErpPoGoods> getByPoId(String poId) {

		return erpPoGoodsMapper.getByPoId(poId);
	}

	public boolean add(ErpPoGoods e) {

		return erpPoGoodsMapper.add(e);
	}

	public void delete(String id) {

		erpPoGoodsMapper.delete(id);
	}

	public List<ErpPoGoods> getAll(String con) {

		return erpPoGoodsMapper.getAll(con);
	}

	public ErpPoGoods getById(String id) {

		return erpPoGoodsMapper.getById(id);
	}

	public void update(ErpPoGoods e) {

		erpPoGoodsMapper.update(e);
	}

	public int getAmount(String poId) {
		
		return erpPoGoodsMapper.getAmount(poId);
	}

}
