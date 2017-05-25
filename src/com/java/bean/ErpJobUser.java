package com.java.bean;

/**
 * 职位用户中间类  字段属性对应 ERP_JOB_USER表
 * @author Admin
 *
 */
public class ErpJobUser {

	private String id;		//编号
	private String job_id;	//职位编号
	private String user_id;	//用户编号
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
}
