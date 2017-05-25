package com.java.mapper;

import java.util.List;

import com.java.bean.ErpSrGoods;

public interface ErpSrGoodsMapper extends Dao<ErpSrGoods,String>{

	public List<ErpSrGoods> getBySrId(String srId);
	//通过主表的id查询总金额
	public int getAmount(String poId);
}
