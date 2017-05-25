package com.java.service;

import java.util.List;

import com.java.bean.ErpSoGoods;

public interface ErpSoGoodsService extends Service<ErpSoGoods,String>{
	
	public List<ErpSoGoods> getBySoId(String soId);
	
	//通过主表的id查询总金额
	public int getAmount(String poId);
}
