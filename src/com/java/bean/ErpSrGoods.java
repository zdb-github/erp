package com.java.bean;

/**
 * �˻�����Ʒ��ϸ�� ��Ӧ�˻���Ʒ��ϸ��
 * 
 * @author Administrator
 *
 */
public class ErpSrGoods {

	private int rownum;
	private String id;				//�ɹ�������ϸ��id
	private String goods_id;		//��Ʒ���
	private int goods_num;			//��Ʒ����
	private int goods_prices;		//��Ʒ�۸�
	private String remark;			//��ע
	private String sr_id;			//�ɹ���������id
	private String warehouse_id;		//�ֿ�id
	public void setSr_id(String sr_id) {
		this.sr_id = sr_id;
	}
	public String getSr_id() {
		return sr_id;
	}
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
	public void setWarehouse_id(String warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public String getWarehouse_id() {
		return warehouse_id;
	}
	
	
	
}