package com.java.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.bean.ErpBlitem;

public interface ErpBlitemService extends Service<ErpBlitem, String> {

	// 通过仓库的ID和商品的ID获取商品所有属性
	public ErpBlitem getNum(@Param("warehouse_id") String warehouse_id,
			@Param("goods_id") String goods_id);

	// 通过仓库的id获取仓库中所有的List<ErpBlitem>
	public List<ErpBlitem> getByWarehouseId(String warehouse_id);

	
	
	//根据仓库的id和商品的id获取盘点单中的对象集合
	public List<ErpBlitem> getByWIAndGI(@Param("warehouse_id") String warehouse_id,
			@Param("goods_id") String goods_id);

}
