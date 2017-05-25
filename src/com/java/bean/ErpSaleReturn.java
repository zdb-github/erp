package com.java.bean;

/**
 * 
 * @author Administrator
 *
 */
public class ErpSaleReturn {

	private int rownum;
	private String sr_id;				//退货单编号
	private String create_time;				//退货日期
	private String customer_id;			//客户id
	private int money;					//金额
	private String payment_method;			//支付方式 
	private String employee_id;			//操作人id
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
	public String getSr_id() {
		return sr_id;
	}
	public void setSr_id(String srId) {
		sr_id = srId;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customerId) {
		customer_id = customerId;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employeeId) {
		employee_id = employeeId;
	}
	public String getInvalid_id() {
		return invalid_id;
	}
	public void setInvalid_id(String invalidId) {
		invalid_id = invalidId;
	}
	public String getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(String organizationId) {
		organization_id = organizationId;
	}
	public String getInvoices_state() {
		return invoices_state;
	}
	public void setInvoices_state(String invoicesState) {
		invoices_state = invoicesState;
	}
	
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setOriginator_id(String originator_id) {
		this.originator_id = originator_id;
	}
	public String getOriginator_id() {
		return originator_id;
	}
	
	
}
