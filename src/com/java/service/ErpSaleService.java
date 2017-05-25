package com.java.service;

import java.util.List;

import com.java.bean.ErpSale;

public interface ErpSaleService extends Service<ErpSale,String>{

	
	public List<ErpSale> selectSale(ErpSale erpSale);
}

