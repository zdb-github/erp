package com.java.bean;

/**
 * 部门类  字段属性对应 ERP_DEPT表
 * @author Admin
 *
 */
public class ErpDept {

	private String dept_id;			//部门编号
	private String name;			//部门名称
	private String subsidiary_organ;//所属部门 SUBSIDIARY_ORGAN
	private String state;			//状态
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubsidiary_organ() {
		return subsidiary_organ;
	}
	public void setSubsidiary_organ(String subsidiary_organ) {
		this.subsidiary_organ = subsidiary_organ;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
