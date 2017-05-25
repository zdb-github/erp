package com.java.mapper;

import java.util.List;

import com.java.bean.ErpWarehouse;

public interface ErpWarehouseMapper extends Dao<ErpWarehouse,String>{
	
	public List<ErpWarehouse> selectWH(ErpWarehouse erpWarehouse);
}
