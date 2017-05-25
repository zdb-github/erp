package com.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeUtil {
	
	public static String getDateAndTime(){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		return sdf.format(date);
	}
	
	public static String getDate(){
		
		Date date  = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		return sdf.format(date);
	}

}
