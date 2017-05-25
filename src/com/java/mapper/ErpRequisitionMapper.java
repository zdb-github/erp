package com.java.mapper;

import org.apache.ibatis.annotations.Param;

import com.java.bean.ErpRequisition;

/*
 * 调拨单
 * 
 */
public interface ErpRequisitionMapper extends Dao<ErpRequisition, String> {

	// 通过仓库的ID和商品的ID获取商品所有属性
	public ErpRequisition getNum(@Param("warehouse_id") String warehouse_id,
			@Param("goods_id") String goods_id);

}
