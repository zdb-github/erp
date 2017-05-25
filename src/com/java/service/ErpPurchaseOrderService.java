package com.java.service;



import java.util.List;

import com.java.bean.ErpPurchaseOrder;

public interface ErpPurchaseOrderService extends Service<ErpPurchaseOrder,String>{

	public List<ErpPurchaseOrder> selectPo(ErpPurchaseOrder erpPuchaseOrder);
	
}

