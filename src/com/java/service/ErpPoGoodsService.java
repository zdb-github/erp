package com.java.service;

import java.util.List;

import com.java.bean.ErpPoGoods;

public interface ErpPoGoodsService extends Service<ErpPoGoods,String>{

	public List<ErpPoGoods> getByPoId(String poId);
	//通过主表的id查询总金额
	public int getAmount(String poId);
}
