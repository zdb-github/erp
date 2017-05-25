package com.java.service;

import java.util.List;

import com.java.bean.ErpJobResource;

public interface ErpJobResourceService extends Service<ErpJobResource,String>{

	public List<ErpJobResource> getByJob_id(String job_id);
}
