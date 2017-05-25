package com.java.mapper;

import java.util.List;

import com.java.bean.ErpPoGoods;

public interface ErpPoGoodsMapper extends Dao<ErpPoGoods,String>{
	
	//通主表的id查询对应主表的商品信息
	public List<ErpPoGoods> getByPoId(String poId);
	
	//通过主表的id查询总金额
	public int getAmount(String poId);
}
