package com.java.bean;

/**
 * 
 * 销售订单类 对应销售订单主表
 * @author Administrator
 *
 */
public class ErpSaleOrder {

	private int rownum;					//
	private String so_id;				//销售订单id		
	private String create_time;				//日期
	private String sale_type;			//销售类型
	private String dept_id;				//部门id
	private String salesman_id;			//销售员id
	private String customer_id;			//客户id
	private String delivery_way;		//发运方式
	private int money;					//金额
	private String payment_method;		//支付方式
	private String originator_id;		//制单人id
	private String invalid_id;			//作废人id
	private String organization_id;		//所属机构id
	private String invoices_state;		//单据状态
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getSo_id() {
		return so_id;
	}
	public void setSo_id(String soId) {
		so_id = soId;
	}
	
	public String getSale_type() {
		return sale_type;
	}
	public void setSale_type(String saleType) {
		sale_type = saleType;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String deptId) {
		dept_id = deptId;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customerId) {
		customer_id = customerId;
	}
	public String getDelivery_way() {
		return delivery_way;
	}
	public void setDelivery_way(String deliveryWay) {
		delivery_way = deliveryWay;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String paymentMethod) {
		payment_method = paymentMethod;
	}
	public String getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(String organizationId) {
		organization_id = organizationId;
	}
	public void setSalesman_id(String salesman_id) {
		this.salesman_id = salesman_id;
	}
	public String getSalesman_id() {
		return salesman_id;
	}
	public void setOriginator_id(String originator_id) {
		this.originator_id = originator_id;
	}
	public String getOriginator_id() {
		return originator_id;
	}
	public void setInvalid_id(String invalid_id) {
		this.invalid_id = invalid_id;
	}
	public String getInvalid_id() {
		return invalid_id;
	}
	public void setInvoices_state(String invoices_state) {
		this.invoices_state = invoices_state;
	}
	public String getInvoices_state() {
		return invoices_state;
	}
	
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCreate_time() {
		return create_time;
	}
	
	
	
}
