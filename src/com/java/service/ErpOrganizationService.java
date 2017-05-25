package com.java.service;

import java.util.List;

import com.java.bean.ErpOrganization;

public interface ErpOrganizationService extends Service<ErpOrganization,String>{

	public List<ErpOrganization> selestOrgan(ErpOrganization erpOrganization);
}
