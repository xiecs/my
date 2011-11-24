package com.dust.apache.commons;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class LangTest {

	private String name = "aa";

	@Override
	public String toString() {

		return ReflectionToStringBuilder.toString(this);
	}
	
	public static void main(String[] args) {
		System.out.println(new LangTest());
	}

}
