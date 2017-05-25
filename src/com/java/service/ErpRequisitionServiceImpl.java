package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpRequisition;
import com.java.mapper.ErpRequisitionMapper;

/*
 * µ÷²¦µ¥
 * 
 */
public class ErpRequisitionServiceImpl implements ErpRequisitionService {

	@Autowired
	private ErpRequisitionMapper erpRequisitionMapper;

	public boolean add(ErpRequisition t) {

		return erpRequisitionMapper.add(t);
	}

	public void delete(String id) {
		erpRequisitionMapper.delete(id);

	}

	public List<ErpRequisition> getAll(String con) {

		return erpRequisitionMapper.getAll(con);
	}

	public ErpRequisition getById(String id) {

		return erpRequisitionMapper.getById(id);
	}

	public void update(ErpRequisition t) {

		erpRequisitionMapper.update(t);

	}

	public ErpRequisition getNum(String warehouseId, String goodsId) {

		return erpRequisitionMapper.getNum(warehouseId, goodsId);
	}

}
