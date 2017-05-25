package com.java.service;

import java.util.List;

import com.java.bean.ErpSrGoods;

public interface ErpSrGoodsService extends Service<ErpSrGoods,String>{

	public List<ErpSrGoods> getBySrId(String srId);
	//通过主表的id查询总金额
	public int getAmount(String poId);
}
