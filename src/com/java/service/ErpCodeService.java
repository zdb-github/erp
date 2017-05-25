package com.java.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.bean.ErpCode;

public interface ErpCodeService extends Service<ErpCode,String> {

	public ErpCode getByKeyAndType(@Param("key")String key, @Param("value")String type);

	public List<ErpCode> getByType(String type);
	
}
