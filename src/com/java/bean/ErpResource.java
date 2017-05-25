package com.java.bean;

/**
 * 资源类  字段属性对应ERP_RESOURCE表
 * @author Admin
 *
 */
public class ErpResource {

	private String id;				//编号
	private String resource_name;	//资源名
	private String do_path;			//路径
	private String role_type;		//角色类型
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}
	public String getDo_path() {
		return do_path;
	}
	public void setDo_path(String do_path) {
		this.do_path = do_path;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	
	
	
	
	
}
