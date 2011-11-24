package com.dust.aop;

public class StudentImpl implements IStudent {

	public void addStudent(String name) {
		System.out.println("新加入学生：" + name);
	}

	public void set(String aa) {
		System.out.println("test");
	}

}
