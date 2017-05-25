package com.java.bean;

import java.util.List;

public class ErpAccount {

	private String id;
	private String username;
	private String password;
	private String uType;
	private String create_time;
	private String last_login_time;
	private String user_id;
	
	private List<ErpComment> erpCommentList;
	
	public List<ErpComment> getErpCommentList() {
		return erpCommentList;
	}
	public void setErpCommentList(List<ErpComment> erpCommentList) {
		this.erpCommentList = erpCommentList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getuType() {
		return uType;
	}
	public void setuType(String uType) {
		this.uType = uType;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getLast_login_time() {
		return last_login_time;
	}
	
	
	
}
