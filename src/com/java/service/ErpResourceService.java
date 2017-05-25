package com.java.service;

import java.util.List;

import com.java.bean.ErpResource;

public interface ErpResourceService extends Service<ErpResource,String>{

	public List<ErpResource> selectResource(ErpResource erpResource);
	public ErpResource getByDo_path(String do_path);
	public List<ErpResource> getByRole_type(String role_type);
}
