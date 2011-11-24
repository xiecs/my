package com.dust.pattern.factory.demo2;

public class OperationAdd extends Operation {

	public OperationAdd() {

	}

	private int a;
	private int b;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public int getResult() {
		return a + b;
	}

}
