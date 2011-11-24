package com.dust.demo;

class AA{
	
	public AA(){
		System.out.println("我是构造函数。。。。");
	}
	
	public static void aa(){
		System.out.println("this static method");
	}
	
}

public class StaticTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AA.aa();

	}

}
