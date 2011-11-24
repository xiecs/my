package com.dust.clone;

import org.apache.commons.lang.builder.ToStringBuilder;

public class MainTest {

	public static void main(String[] args) {

		Data data = new Data("aaa", 444);

		System.out.println(ToStringBuilder.reflectionToString(data));

		//----------浅拷贝---------
//		Data dataClone = (Data) data.clone();
//		dataClone.setA(888);
//		dataClone.getData1().setAa("========");
//
//		System.out.println(ToStringBuilder.reflectionToString(data) + "...."
//				+ ToStringBuilder.reflectionToString(data.getData1()));
//		System.out.println(ToStringBuilder.reflectionToString(dataClone) + "...."
//				+ ToStringBuilder.reflectionToString(dataClone.getData1()));
		
		//-----------深拷贝--------
		Data deepClone = (Data) data.deepClone();
		deepClone.setA(888);
		deepClone.getData1().setAa("========");

		System.out.println(ToStringBuilder.reflectionToString(data) + "...."
				+ ToStringBuilder.reflectionToString(data.getData1()));
		System.out.println(ToStringBuilder.reflectionToString(deepClone) + "...."
				+ ToStringBuilder.reflectionToString(deepClone.getData1()));
	}

}
