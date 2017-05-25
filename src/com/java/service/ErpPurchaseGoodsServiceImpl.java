package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpPurchaseGoods;
import com.java.mapper.ErpPurchaseGoodsMapper;

public class ErpPurchaseGoodsServiceImpl implements ErpPurchaseGoodsService{

	@Autowired
	private ErpPurchaseGoodsMapper erpPurchaseGoodsMapper;
	
	public List<ErpPurchaseGoods> getByPurchaseId(String purchaseId) {

		return erpPurchaseGoodsMapper.getByPurchaseId(purchaseId);
	}

	public boolean add(ErpPurchaseGoods e) {

		return erpPurchaseGoodsMapper.add(e);
	}

	public void delete(String id) {

		erpPurchaseGoodsMapper.delete(id);
	}

	public List<ErpPurchaseGoods> getAll(String con) {

		return erpPurchaseGoodsMapper.getAll(con);
	}

	public ErpPurchaseGoods getById(String id) {

		return erpPurchaseGoodsMapper.getById(id);
	}

	public void update(ErpPurchaseGoods e) {

		erpPurchaseGoodsMapper.update(e);
	}

	public int getAmount(String poId) {
		return erpPurchaseGoodsMapper.getAmount(poId);
	}

}
