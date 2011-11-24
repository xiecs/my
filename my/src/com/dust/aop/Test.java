package com.dust.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext ctx = new FileSystemXmlApplicationContext("/config/applicationContext-aop-test.xml");
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/dust/aop/applicationContext-aop-test.xml");

		IStudent person = (IStudent) ctx.getBean("student");
//		person.addStudent("dragon");
		person.set("aa");

		// person.addStudent("javadragon");
	}

}
