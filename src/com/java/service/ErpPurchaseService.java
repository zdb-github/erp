package com.java.service;

import java.util.List;

import com.java.bean.ErpPurchase;

public interface ErpPurchaseService extends Service<ErpPurchase,String>{

	public List<ErpPurchase> selectPurchase(ErpPurchase erpPurchase);
	
}

