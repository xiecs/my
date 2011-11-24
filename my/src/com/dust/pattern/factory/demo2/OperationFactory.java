package com.dust.pattern.factory.demo2;

/**
 * 工厂模式 由工厂统一来创建对象的实例
 * 
 */
public class OperationFactory {

	public static void main(String[] args) {
		AddFactory operFactory = new AddFactory();
		OperationAdd oper = operFactory.createOperation();
		oper.setA(11);
		oper.setB(33);

		System.out.println(oper.getResult());

	}

}
