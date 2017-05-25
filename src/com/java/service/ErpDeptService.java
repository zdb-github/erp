package com.java.service;

import java.util.List;

import com.java.bean.ErpDept;

public interface ErpDeptService extends Service<ErpDept,String> {

	public List<ErpDept> selectDept(ErpDept erpDetp);
}
