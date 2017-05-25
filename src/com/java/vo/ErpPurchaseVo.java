package com.java.vo;

public class ErpPurchaseVo {

	private String purchase_id;				//采购单单据号
	private String create_time;				//采购日期
	private String supplier_id;			//供应商id
	private String dept_id;				//采购部门id
	private String purchaser_id;			//采购员id
	private String warehouse_id;		//仓库id
	private int purchase_amount;				//采购金额
	private String originator_id;			//制单人
	private String invalid_id;				//作废人
	private String organization_id;		//所属机构
	private String invoices_state;			//单据状态
	
	private String supplier_name;
	private String dept_name;
	private String purchaser_name;
	private String warehouse_name;
	private String originator_name;
	private String invalid_name;
	private String organization_name;
	private String stateVo;
	public String getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(String purchaseId) {
		purchase_id = purchaseId;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String createTime) {
		create_time = createTime;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplierId) {
		supplier_id = supplierId;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String deptId) {
		dept_id = deptId;
	}
	public String getPurchaser_id() {
		return purchaser_id;
	}
	public void setPurchaser_id(String purchaserId) {
		purchaser_id = purchaserId;
	}
	public String getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(String warehouseId) {
		warehouse_id = warehouseId;
	}
	public String getOriginator_id() {
		return originator_id;
	}
	public void setOriginator_id(String originatorId) {
		originator_id = originatorId;
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
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplierName) {
		supplier_name = supplierName;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String deptName) {
		dept_name = deptName;
	}
	public String getPurchaser_name() {
		return purchaser_name;
	}
	public void setPurchaser_name(String purchaserName) {
		purchaser_name = purchaserName;
	}
	public String getWarehouse_name() {
		return warehouse_name;
	}
	public void setWarehouse_name(String warehouseName) {
		warehouse_name = warehouseName;
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
	public String getStateVo() {
		return stateVo;
	}
	public void setStateVo(String stateVo) {
		this.stateVo = stateVo;
	}
	public void setPurchase_amount(int purchase_amount) {
		this.purchase_amount = purchase_amount;
	}
	public int getPurchase_amount() {
		return purchase_amount;
	}
	
	
	
}
