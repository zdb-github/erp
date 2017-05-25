package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpSrGoods;
import com.java.mapper.ErpSrGoodsMapper;

public class ErpSrGoodsServiceImpl implements ErpSrGoodsService{

	@Autowired
	private ErpSrGoodsMapper erpSrGoodsMapper;
	
	public List<ErpSrGoods> getBySrId(String srId) {

		return erpSrGoodsMapper.getBySrId(srId);
	}

	public boolean add(ErpSrGoods e) {

		return erpSrGoodsMapper.add(e);
	}

	public void delete(String id) {

		erpSrGoodsMapper.delete(id);
	}

	public List<ErpSrGoods> getAll(String con) {

		return erpSrGoodsMapper.getAll(con);
	}

	public ErpSrGoods getById(String id) {

		return erpSrGoodsMapper.getById(id);
	}

	public void update(ErpSrGoods e) {

		erpSrGoodsMapper.update(e);
	}

	public int getAmount(String poId) {

		return erpSrGoodsMapper.getAmount(poId);
	}

}
