package com.dust.pattern.strategy.demo1;

public class JiaFa extends SuanFa {

	private int a;
	private int b;

	public JiaFa(int a, int b) {
		this.a = a;
		this.b = b;
	}

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
	public String exec() {
		return String.valueOf(a + b);
	}

}
