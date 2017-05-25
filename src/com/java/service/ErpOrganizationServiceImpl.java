package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.bean.ErpOrganization;
import com.java.mapper.ErpOrganizationMapper;

public class ErpOrganizationServiceImpl implements ErpOrganizationService{

	@Autowired
	private ErpOrganizationMapper erpOrganizationMapper;
	
	public boolean add(ErpOrganization t) {
		
		return erpOrganizationMapper.add(t);
	}

	public void delete(String id) {
		erpOrganizationMapper.delete(id);
		
	}

	public void update(ErpOrganization t) {
		erpOrganizationMapper.update(t);
		
	}

	public List<ErpOrganization> getAll(String con) {
		
		return erpOrganizationMapper.getAll(con);
	}

	public ErpOrganization getById(String id) {
		
		return erpOrganizationMapper.getById(id);
	}

	public List<ErpOrganization> selestOrgan(ErpOrganization erpOrganization) {
		
		return erpOrganizationMapper.selestOrgan(erpOrganization);
	}

}
