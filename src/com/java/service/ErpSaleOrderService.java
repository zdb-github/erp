package com.java.service;

import java.util.List;

import com.java.bean.ErpSaleOrder;

public interface ErpSaleOrderService extends Service<ErpSaleOrder,String>{

	public List<ErpSaleOrder> selectSaleOrder(ErpSaleOrder erpSaleOrder);
}

