package com.java.mapper;

import java.util.List;


import com.java.bean.ErpSaleGoods;

public interface ErpSaleGoodsMapper extends Dao<ErpSaleGoods,String>{

	public List<ErpSaleGoods> getBySaleId(String saleId);
	//通过主表的id查询总金额
	public int getAmount(String saleId);
}
