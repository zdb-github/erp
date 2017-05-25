package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.bean.ErpCode;

public interface ErpCodeMapper extends Dao<ErpCode, String> {

	
	public ErpCode getByKeyAndType(@Param("key")String key, @Param("type")String type);

	public List<ErpCode> getByType(String type);
}
