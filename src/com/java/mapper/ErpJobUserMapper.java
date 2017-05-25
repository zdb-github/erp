package com.java.mapper;

import com.java.bean.ErpJobUser;

public interface ErpJobUserMapper extends Dao<ErpJobUser,String>{

	public ErpJobUser getByUser_id(String user_id);
	
}
