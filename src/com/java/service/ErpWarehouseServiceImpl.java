package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpWarehouse;
import com.java.mapper.ErpWarehouseMapper;

public class ErpWarehouseServiceImpl implements ErpWarehouseService{

	@Autowired
	private ErpWarehouseMapper erpWarehouseMapper;
	
	public boolean add(ErpWarehouse t) {
		
		return erpWarehouseMapper.add(t);
	}

	public void delete(String id) {
		erpWarehouseMapper.delete(id);
		
	}

	public void update(ErpWarehouse t) {
		erpWarehouseMapper.update(t);
		
	}

	public List<ErpWarehouse> getAll(String con) {
		
		return erpWarehouseMapper.getAll(con);
	}

	public ErpWarehouse getById(String id) {
		
		return erpWarehouseMapper.getById(id);
	}

	public List<ErpWarehouse> selectWH(ErpWarehouse erpWarehouse) {
		
		return erpWarehouseMapper.selectWH(erpWarehouse);
	}

}
