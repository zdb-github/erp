package com.java.bean;

import java.util.List;

public class ErpComment {

	private String id;
	private String content;
	private String comment_time;
	private String account_id;
	
	private List<ErpReply> erpReplyList;
	
	
	public List<ErpReply> getErpReplyList() {
		return erpReplyList;
	}
	public void setErpReplyList(List<ErpReply> erpReplyList) {
		this.erpReplyList = erpReplyList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String commentTime) {
		comment_time = commentTime;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String accountId) {
		account_id = accountId;
	}
	
}
