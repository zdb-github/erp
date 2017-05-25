package com.java.bean;

public class Page {
	
	private int totalRecode;		//总记录数
	private int pageSize;			//每页显示条数
	private int currentPage;		//当前页数
	private int pageCount;			//总页数
	public int getTotalRecode() {
		return totalRecode;
	}
	public void setTotalRecode(int totalRecode) {
		this.totalRecode = totalRecode;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
