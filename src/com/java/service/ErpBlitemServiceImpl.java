package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpBlitem;
import com.java.mapper.ErpBlitemMapper;

/*
 * 这是一张盘点单
 */
public class ErpBlitemServiceImpl implements ErpBlitemService {

	@Autowired
	private ErpBlitemMapper erpBlitemMapper;

	public boolean add(ErpBlitem t) {

		return erpBlitemMapper.add(t);
	}

	public void delete(String id) {
		erpBlitemMapper.delete(id);

	}

	public List<ErpBlitem> getAll(String con) {

		return erpBlitemMapper.getAll(con);
	}

	public ErpBlitem getById(String id) {

		return erpBlitemMapper.getById(id);
	}

	public void update(ErpBlitem t) {

		erpBlitemMapper.update(t);

	}

	// 通过仓库的id获取仓库中所有的List<ErpBlitem>
	public List<ErpBlitem> getByWarehouseId(String warehouseId) {

		return erpBlitemMapper.getByWarehouseId(warehouseId);
	}

	// 通过仓库的ID和商品的ID获取商品所有属性
	public ErpBlitem getNum(String warehouseId, String goodsId) {

		return erpBlitemMapper.getNum(warehouseId, goodsId);
	}

	public List<ErpBlitem> getByWIAndGI(String warehouseId, String goodsId) {
		
		return erpBlitemMapper.getByWIAndGI(warehouseId, goodsId);
	}

}
