package com.java.mapper;

import java.util.List;

import com.java.bean.ErpResource;

public interface ErpResourceMapper extends Dao<ErpResource,String>{

	public List<ErpResource> selectResource(ErpResource erpResource);
	public ErpResource getByDo_path(String do_path);
	public List<ErpResource> getByRole_type(String roleType);
}
