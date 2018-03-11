package com.basics.practice;

import java.util.Date;

public class DatesProg {
	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println(d1.toString());
		Date d2 = new Date();
		System.out.println(d2.toString());
		boolean isSameDay = UtilityProg.isSameDay(d1, d2);
		System.out.println(isSameDay);
		
		//Getting the time as per timezone CST
		String timeZoneName = TimeZones.getTimeZoneName("ADT");
		System.out.println(timeZoneName);
		Date convertedDate = UtilityProg.convertDate(d1, "ADT");
		System.out.println(convertedDate);
		
		//String to Date
		System.out.println("Converting String to Date");
//		String strDate = "2015-01-20"; OR
		String strDate = "01/20/2015";
		Date date = DateUtil.string2date(strDate);
		System.out.println(date);
		
		//Date to String
		System.out.println("Conversting Date to String");
		String strDate2 = DateUtil.date2string(date);
		System.out.println(strDate2);
	}

}
