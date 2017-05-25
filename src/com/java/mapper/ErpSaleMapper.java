package com.java.mapper;

import java.util.List;

import com.java.bean.ErpSale;

public interface ErpSaleMapper extends Dao <ErpSale,String>{

	
	public List<ErpSale> selectSale(ErpSale erpSale);
}
