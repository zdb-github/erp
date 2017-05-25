package com.java.service;

import java.util.List;

import com.java.bean.ErpSaleReturn;

public interface ErpSaleReturnService extends Service<ErpSaleReturn,String>{

	public List<ErpSaleReturn> selectSaleReturn(ErpSaleReturn erpSaleReturn);
	
}
