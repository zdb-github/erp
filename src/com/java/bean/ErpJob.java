package com.java.bean;

/**
 * 职位类   字段属性对应ERP_JOB表
 * @author Admin
 *
 */
public class ErpJob {

	private String job_id;		//职位编号
	private String job_name;	//职位名称
	private String state;		//状态
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
