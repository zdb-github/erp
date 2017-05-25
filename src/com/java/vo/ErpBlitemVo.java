package com.java.vo;

public class ErpBlitemVo {

	private int rownum;   //分页属性
	private String blitem_id;    //编号
	private String warehouse_id;   //仓库ID
	private String goods_id;   //商品编号
	private int num;       //盘点前的数量
	private int check_num;    //盘点数量
	private int profit_and_loss;    //盈亏数量
	private String handler_id;     //经手人
	
	private String warehouse_name;
	private String goods_name;
	private String handler_name;
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getBlitem_id() {
		return blitem_id;
	}
	public void setBlitem_id(String blitemId) {
		blitem_id = blitemId;
	}
	public String getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(String warehouseId) {
		warehouse_id = warehouseId;
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
	public int getCheck_num() {
		return check_num;
	}
	public void setCheck_num(int checkNum) {
		check_num = checkNum;
	}
	public int getProfit_and_loss() {
		return profit_and_loss;
	}
	public void setProfit_and_loss(int profitAndLoss) {
		profit_and_loss = profitAndLoss;
	}
	public String getHandler_id() {
		return handler_id;
	}
	public void setHandler_id(String handlerId) {
		handler_id = handlerId;
	}
	public String getWarehouse_name() {
		return warehouse_name;
	}
	public void setWarehouse_name(String warehouseName) {
		warehouse_name = warehouseName;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
	}
	public String getHandler_name() {
		return handler_name;
	}
	public void setHandler_name(String handlerName) {
		handler_name = handlerName;
	}
	
	
	
}
