package com.java.vo;

public class ErpCashStatementVo {


	private int rownum;   //分页属性
	private String statement_id;   //编号
	private String goods_id;   //商品编号
	private String warehouse_id;   //仓库id
	private int goods_num;     //仓库货品数量
	
	private String goods_name;	//商品名称
	private int goods_prices;	//商品价格
	private String goods_type;		//商品类型
	private String goods_unit;		//商品单位
	private String warehouse_name;
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
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
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
	}
	public int getGoods_prices() {
		return goods_prices;
	}
	public void setGoods_prices(int goodsPrices) {
		goods_prices = goodsPrices;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goodsType) {
		goods_type = goodsType;
	}
	public String getGoods_unit() {
		return goods_unit;
	}
	public void setGoods_unit(String goodsUnit) {
		goods_unit = goodsUnit;
	}
	public String getWarehouse_name() {
		return warehouse_name;
	}
	public void setWarehouse_name(String warehouseName) {
		warehouse_name = warehouseName;
	}
	
	
}
