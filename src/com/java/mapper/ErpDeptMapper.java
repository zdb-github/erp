package com.java.mapper;

import java.util.List;

import com.java.bean.ErpDept;

public interface ErpDeptMapper extends Dao<ErpDept,String>{

	public List<ErpDept> selectDept(ErpDept erpDetp);
}
