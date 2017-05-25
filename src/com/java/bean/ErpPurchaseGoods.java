package com.java.bean;

/**
 * 采购单明细类对应采购单明细表
 * 
 * @author Administrator
 *
 */
public class ErpPurchaseGoods {

	private int rownum;
	private String id;				//采购单明细表id
	private String goods_id;		//商品编号
	private int goods_num;			//商品数量
	private int goods_prices;		//商品价格
	private String remark;			//备注
	private String purchase_id;			//采购订单主表id
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

	public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getPurchase_id() {
		return purchase_id;
	}
	
}
