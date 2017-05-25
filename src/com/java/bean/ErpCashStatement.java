package com.java.bean;

/*
 * 这是一张仓库余额的pojo
 */

public class ErpCashStatement {
	
	private int rownum;   //分页属性
	private String statement_id;   //编号
	private String goods_id;   //商品编号
	private String warehouse_id;   //仓库id
	private int goods_num;     //仓库货品数量
	
	public String getStatement_id() {
		return statement_id;
	}
	public void setStatement_id(String statementId) {
		statement_id = statementId;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goodsId) {
		goods_id = goodsId;
	}
	public String getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(String warehouseId) {
		warehouse_id = warehouseId;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goodsNum) {
		goods_num = goodsNum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getRownum() {
		return rownum;
	}
	
	
}
