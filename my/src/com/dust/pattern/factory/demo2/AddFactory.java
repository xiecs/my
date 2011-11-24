package com.dust.pattern.factory.demo2;

public class AddFactory implements IFactory {

	public OperationAdd createOperation() {
		
		return new OperationAdd();
	}

}
