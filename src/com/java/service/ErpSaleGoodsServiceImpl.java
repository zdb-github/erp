package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpSaleGoods;
import com.java.mapper.ErpSaleGoodsMapper;

public class ErpSaleGoodsServiceImpl implements ErpSaleGoodsService{

	@Autowired
	private ErpSaleGoodsMapper erpSaleGoodsMapper;
	
	public List<ErpSaleGoods> getBySaleId(String saleId) {

		return erpSaleGoodsMapper.getBySaleId(saleId);
	}

	public boolean add(ErpSaleGoods e) {

		return erpSaleGoodsMapper.add(e);
	}

	public void delete(String id) {

		erpSaleGoodsMapper.delete(id);
	}

	public List<ErpSaleGoods> getAll(String con) {

		return erpSaleGoodsMapper.getAll(con);
	}

	public ErpSaleGoods getById(String id) {

		return erpSaleGoodsMapper.getById(id);
	}

	public void update(ErpSaleGoods e) {

		erpSaleGoodsMapper.update(e);
	}

	public int getAmount(String poId) {

		return erpSaleGoodsMapper.getAmount(poId);
	}

}
