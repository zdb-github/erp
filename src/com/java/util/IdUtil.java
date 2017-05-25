package com.java.util;

import java.util.Calendar;
import java.util.UUID;



public class IdUtil {

	
	/**
	 * 获取单据和商品的id
	 * @return
	 */
	public static String getInvoicesId(){
		
		Calendar calendar = Calendar.getInstance();
		String id = ""+calendar.getTime().getTime();
		return id;
		
	}
	
	/**
	 * 获取uuid的方法
	 * @return
	 */
	public static String getUuid(){
		
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	
}
