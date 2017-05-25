package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpCashStatement;
import com.java.mapper.ErpCashStatementMapper;

/*
 * 仓库余额表
 */
public class ErpCashStatementServiceImpl implements ErpCashStatementService {

	@Autowired
	private ErpCashStatementMapper erpCashStatementMapper;

	// 通过仓库的ID获取集合
	public List<ErpCashStatement> getByWarehouseId(String warehouseId) {

		return erpCashStatementMapper.getByWarehouseId(warehouseId);
	}

	// 通过仓库的ID和商品的ID获取商品的余量
	public int getNum(String warehouseId, String goodsId) {

		return erpCashStatementMapper.getNum(warehouseId, goodsId);
	}

	public boolean add(ErpCashStatement t) {

		return erpCashStatementMapper.add(t);
	}

	public void delete(String id) {

		erpCashStatementMapper.delete(id);

	}

	public List<ErpCashStatement> getAll(String con) {

		return erpCashStatementMapper.getAll(con);
	}

	public ErpCashStatement getById(String id) {

		return erpCashStatementMapper.getById(id);
	}

	public void update(ErpCashStatement t) {

		erpCashStatementMapper.update(t);
	}
	//通过商品id和仓库的id来获取对象的集合
	public List<ErpCashStatement> getByWIAndGI(String warehouseId,
			String goodsId) {
		
		return erpCashStatementMapper.getByWIAndGI(warehouseId, goodsId);
	}

	public void updateNum(ErpCashStatement erpcash) {
		erpCashStatementMapper.updateNum(erpcash);
		
	}

	

}
