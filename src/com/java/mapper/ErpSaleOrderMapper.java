package com.java.mapper;

import java.util.List;

import com.java.bean.ErpSaleOrder;

public interface ErpSaleOrderMapper extends Dao<ErpSaleOrder,String>{

	public List<ErpSaleOrder> selectSaleOrder(ErpSaleOrder erpSaleOrder);
}
