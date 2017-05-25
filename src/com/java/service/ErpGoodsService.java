package com.java.service;

import java.util.List;

import com.java.bean.ErpGoods;

public interface ErpGoodsService extends Service<ErpGoods,String>{

	public List<ErpGoods> selectGoods(ErpGoods erpGoods);
}
