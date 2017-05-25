package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.bean.ErpAccount;


public interface ErpAccountMapper extends Dao<ErpAccount, String> {

	public ErpAccount checkLogin(@Param("username")String username,@Param("password")String password);
	
	//获得所有用户及每个用户的所有评论
	public  List<ErpAccount>getErpAccountAndErpCommentAll();
	
	//获得所有用户及每个用户的所有评论及每个评论的所有回复信息
	public List<ErpAccount>getErpAccountAndErpCommentAndErpReplyAll();
	
	//zdb----
	//根据用户名判断是否已经存在
	public int checkTheSameUsername(String username);

}



















