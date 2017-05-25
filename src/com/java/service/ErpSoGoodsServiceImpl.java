package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpSoGoods;
import com.java.mapper.ErpSoGoodsMapper;

public class ErpSoGoodsServiceImpl implements ErpSoGoodsService{

	@Autowired
	private ErpSoGoodsMapper erpSoGoodsMapper;
	
	public List<ErpSoGoods> getBySoId(String soId) {

		return erpSoGoodsMapper.getBySoId(soId);
	}

	public boolean add(ErpSoGoods e) {

		return erpSoGoodsMapper.add(e);
	}

	public void delete(String id) {

		erpSoGoodsMapper.delete(id);
	}

	public List<ErpSoGoods> getAll(String con) {

		return erpSoGoodsMapper.getAll(con);
	}

	public ErpSoGoods getById(String id) {

		return erpSoGoodsMapper.getById(id);
	}

	public void update(ErpSoGoods e) {

		erpSoGoodsMapper.update(e);
	}

	public int getAmount(String poId) {

		return erpSoGoodsMapper.getAmount(poId);
	}

}
