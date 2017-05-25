package com.java.bean;

/**
 * 采购订单类 对应采购订单主表ERP_PURCHASE_ORDER
 * 
 * @author Administrator
 *
 */
public class ErpPurchaseOrder {
	
	private int rownum;					//
	private String po_id;				//采购订单单据号
	private String create_time;				//采购日期
	private String supplier_id;			//供应商id
	private String dept_id;				//采购部门id
	private String purchaser_id;			//采购员id
	private String warehouse_id;		//仓库id
	private int po_amount;				//采购金额
	private String originator_id;			//制单人
	private String invalid_id;				//作废人
	private String organization_id;		//所属机构
	private String invoices_state;			//单据状态
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getPo_id() {
		return po_id;
	}
	public void setPo_id(String poId) {
		po_id = poId;
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
	public String getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(String warehouseId) {
		warehouse_id = warehouseId;
	}
	public int getPo_amount() {
		return po_amount;
	}
	public void setPo_amount(int poAmount) {
		po_amount = poAmount;
	}
	public String getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(String organizationId) {
		organization_id = organizationId;
	}
	public void setPurchaser_id(String purchaser_id) {
		this.purchaser_id = purchaser_id;
	}
	public String getPurchaser_id() {
		return purchaser_id;
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
