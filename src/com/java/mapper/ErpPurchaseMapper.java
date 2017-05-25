package com.java.mapper;

import java.util.List;

import com.java.bean.ErpPurchase;

public interface ErpPurchaseMapper extends Dao<ErpPurchase,String>{

	public List<ErpPurchase> selectPurchase(ErpPurchase erpPurchase);
	
}
