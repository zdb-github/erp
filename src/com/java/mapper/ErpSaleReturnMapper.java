package com.java.mapper;

import java.util.List;

import com.java.bean.ErpSaleReturn;

public interface ErpSaleReturnMapper extends Dao<ErpSaleReturn,String>{

	public List<ErpSaleReturn> selectSaleReturn(ErpSaleReturn erpSaleReturn);
	
}
