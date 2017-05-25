package com.java.vo;

public class ErpSaleGoodsVo {

	private int rownum;
	private String id;				//采购订单明细表id
	private String goods_id;		//商品编号
	private int goods_num;			//商品数量
	private int goods_prices;		//商品价格
	private String remark;			//备注
	private String sale_id;			//销售订单主表id
	private String warehouse_id;
	private String goods_name;
	private String goods_type;		//商品类型
	private String goods_unit;		//商品单位
	private String warehouse_name;	//商品所在仓库
	private int sumAmount;
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goodsId) {
		goods_id = goodsId;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goodsNum) {
		goods_num = goodsNum;
	}
	public int getGoods_prices() {
		return goods_prices;
	}
	public void setGoods_prices(int goodsPrices) {
		goods_prices = goodsPrices;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSale_id() {
		return sale_id;
	}
	public void setSale_id(String saleId) {
		sale_id = saleId;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
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
	public int getSumAmount() {
		int sumAmount = this.goods_num*this.goods_prices;
		return sumAmount;
	}
	public void setWarehouse_id(String warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public String getWarehouse_id() {
		return warehouse_id;
	}
	
	
	
}
