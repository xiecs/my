package com.dust.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class DateSample {

	public static void main(String[] args) throws ParseException {
		String s = "20110223111716";
		
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = f.parse(s);
		System.out.println(d);

	
		String [] arg=new String[]{"yyyyMMddhhmmss"};
		System.out.println(DateUtils.parseDate(s,arg));
	}

}
