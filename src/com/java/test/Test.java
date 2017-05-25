package com.java.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.java.bean.ErpGoods;
import com.java.service.ErpGoodsService;

@Controller
public class Test {

	@Autowired
	private static ErpGoodsService erpGoodsService;
	
	public static void main(String[] args) {
		
		ErpGoods eg = erpGoodsService.getById("1409209320999");
		
		System.out.println(eg.getGoods_name());
		
	}
}
