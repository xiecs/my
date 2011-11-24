package com.dust.pattern.factory.demo1;

/**
 * 工厂模式 
 * 由工厂统一来创建对象的实例
 * 
 */
public class OperationFactory {

	private OperationFactory() {

	}

	public static Operation createPoerate(Operate operate) {
		Operation op = null;
		switch (operate) {
		case ADD:
			op = new OperationAdd();
			break;
		}
		return op;
	}

	public static void main(String[] args) {
		OperationAdd add = (OperationAdd) OperationFactory.createPoerate(Operate.ADD);
		add.setA(11);
		add.setB(888);
		System.out.println(add.getResult());
	}

}
