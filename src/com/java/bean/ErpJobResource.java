package com.java.bean;

/**
 * 职位资源中间类 字段属性对应ERP_JOB_RESOURCE表
 * @author Admin
 *
 */
public class ErpJobResource {

	private String id;		//编号
	private String job_id;	//职位编号
	private String resource_id;	//资源编号
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getResource_id() {
		return resource_id;
	}
	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}
	
	
	
	
	
}
