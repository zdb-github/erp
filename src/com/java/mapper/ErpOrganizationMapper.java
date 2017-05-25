package com.java.mapper;

import java.util.List;

import com.java.bean.ErpOrganization;

public interface ErpOrganizationMapper extends Dao<ErpOrganization,String>{

	public List<ErpOrganization> selestOrgan(ErpOrganization erpOrganization);
}
