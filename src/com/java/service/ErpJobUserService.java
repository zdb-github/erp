package com.java.service;

import com.java.bean.ErpJobUser;

public interface ErpJobUserService extends Service<ErpJobUser,String>{

	public ErpJobUser getByUser_id(String user_id);
}
