package com.java.service;

import java.util.List;

import com.java.bean.ErpWarehouse;

public interface ErpWarehouseService extends Service<ErpWarehouse,String>{

	public List<ErpWarehouse> selectWH(ErpWarehouse erpWarehouse);
}
