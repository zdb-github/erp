package com.java.vo;

public class ErpSaleReturnVo {

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
	
	private String paymentMethodVo;
	private String customer_name;
	private String dept_name;
	private String employee_name;
	private String originator_name;
	private String invalid_name;
	private String organization_name;
	private String stateVo;		//单据状态
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
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String createTime) {
		create_time = createTime;
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
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String paymentMethod) {
		payment_method = paymentMethod;
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
	public String getPaymentMethodVo() {
		return paymentMethodVo;
	}
	public void setPaymentMethodVo(String paymentMethodVo) {
		this.paymentMethodVo = paymentMethodVo;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customerName) {
		customer_name = customerName;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String deptName) {
		dept_name = deptName;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employeeName) {
		employee_name = employeeName;
	}
	public String getOriginator_name() {
		return originator_name;
	}
	public void setOriginator_name(String originatorName) {
		originator_name = originatorName;
	}
	public String getInvalid_name() {
		return invalid_name;
	}
	public void setInvalid_name(String invalidName) {
		invalid_name = invalidName;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organizationName) {
		organization_name = organizationName;
	}
	public void setOriginator_id(String originator_id) {
		this.originator_id = originator_id;
	}
	public String getOriginator_id() {
		return originator_id;
	}
	public void setStateVo(String stateVo) {
		this.stateVo = stateVo;
	}
	public String getStateVo() {
		return stateVo;
	}
	
	
	
}
