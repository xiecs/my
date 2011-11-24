package com.dust.child;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Father obj = new Child();
		// 类要看具体new的类，左边只是这个类的声明(可以是接口，也可以是父类)
		System.out.println(obj.getClass().getSimpleName());
		System.out.println(obj.getClass().getSuperclass());
		
		IFather obj1 = new Child();
		System.out.println(obj1.getClass().getSimpleName());
		System.out.println(obj1.getClass().getInterfaces());

		
	}

}
