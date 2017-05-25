package com.java.mapper;

import java.util.List;

import com.java.bean.ErpPurchaseOrder;

public interface ErpPurchaseOrderMapper extends Dao<ErpPurchaseOrder,String>{
	
	
	public List<ErpPurchaseOrder> selectPo(ErpPurchaseOrder erpPuchaseOrder);
	
}
