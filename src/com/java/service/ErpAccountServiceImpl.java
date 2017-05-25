package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpAccount;
import com.java.mapper.ErpAccountMapper;

public class ErpAccountServiceImpl implements ErpAccountService {

	@Autowired
	private ErpAccountMapper erpAccountMapper;
	public ErpAccount checkLogin(String username, String password) {
		return erpAccountMapper.checkLogin(username, password);
	}

	public boolean add(ErpAccount t) {
		return erpAccountMapper.add(t);
	}

	public void delete(String id) {
		erpAccountMapper.delete(id);
	}

	public List<ErpAccount> getAll(String con) {
		return erpAccountMapper.getAll(con);
	}

	public ErpAccount getById(String id) {
		return erpAccountMapper.getById(id);
	}

	public void update(ErpAccount t) {
		erpAccountMapper.update(t);
	}

	public List<ErpAccount> getErpAccountAndErpCommentAll() {
		return erpAccountMapper.getErpAccountAndErpCommentAll();
	}

	public List<ErpAccount> getErpAccountAndErpCommentAndErpReplyAll() {
		return erpAccountMapper.getErpAccountAndErpCommentAndErpReplyAll();
	}

	public int checkTheSameUsername(String username) {
		
		return erpAccountMapper.checkTheSameUsername(username);
	}

}
