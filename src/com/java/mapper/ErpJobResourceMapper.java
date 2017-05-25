package com.java.mapper;

import java.util.List;

import com.java.bean.ErpJobResource;

public interface ErpJobResourceMapper extends Dao<ErpJobResource,String> {

	public List<ErpJobResource> getByJob_id(String job_id);
}
