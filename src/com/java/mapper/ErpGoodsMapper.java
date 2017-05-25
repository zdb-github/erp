package com.java.mapper;

import java.util.List;

import com.java.bean.ErpGoods;

public interface ErpGoodsMapper extends Dao<ErpGoods,String>{

	public List<ErpGoods> selectGoods(ErpGoods erpGoods);
}
