package com.java.service;

import java.util.List;

import com.java.bean.ErpPurchaseGoods;

public interface ErpPurchaseGoodsService extends Service<ErpPurchaseGoods,String>{

	//通主表的id查询对应主表的商品信息
	public List<ErpPurchaseGoods> getByPurchaseId(String purchaseId);
	
	//通过主表的id查询总金额
	public int getAmount(String poId);
}

