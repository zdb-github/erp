package com.java.bean;

/*
 * 商品销量
 * 
 */
public class ErpGoodsSale {
	
	private int rownum;   //分页属性
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	private String goods_sale_id;   //编号
	private String goods_id;     //商品编号
	private int  num;         //商品销售数量
	private String warehouse_id;   //仓库ID
	private String quarter;    //季度
	private String month;    //月份
	private String sale_time;   //销售时间
	private String customer_id;   //客户ID
	public String getGoods_sale_id() {
		return goods_sale_id;
	}
	public void setGoods_sale_id(String goodsSaleId) {
		goods_sale_id = goodsSaleId;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goodsId) {
		goods_id = goodsId;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(String warehouseId) {
		warehouse_id = warehouseId;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getSale_time() {
		return sale_time;
	}
	public void setSale_time(String saleTime) {
		sale_time = saleTime;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customerId) {
		customer_id = customerId;
	}
	
	
}
