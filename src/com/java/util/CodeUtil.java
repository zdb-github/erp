package com.java.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bean.ErpCode;
import com.java.mapper.ErpCodeMapper;

public class CodeUtil {

	private static BeanFactory factory = new  ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
	private static ErpCodeMapper erpCodeMapper = factory.getBean("erpCodeMapper", ErpCodeMapper.class);
	
	
	
	public static String getValue(String key,String type){
		ErpCode ec = erpCodeMapper.getByKeyAndType(key, type);
		return ec.getValue();
		
	}
	
	public static String getValues(String keys,String type){
		
		String valueStr = "";
		if(keys.length()!=0){
			if(keys.length()==1){
				
				valueStr =getValue(keys,type);
			}else{
				String[] keyArr = keys.split(",");
				for(int i=0;i<keyArr.length;i++){
					valueStr+=CodeUtil.getValue(keyArr[i], type)+",";
				}
				valueStr = valueStr.substring(0,valueStr.length()-1);
			}
		}
		return valueStr;
	}
}
