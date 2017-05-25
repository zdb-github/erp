package com.java.bean;

/**
 * 机构类  字段属性对应ERP_ORGANIZATION表
 * @author Admin
 *
 */
public class ErpOrganization {

	private String organization_id;  //机构编号
	private String name;			//机构名称
	private String address;			//机构所在地
	private String state;			//状态
	public String getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(String organization_id) {
		this.organization_id = organization_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
