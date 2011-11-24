package com.dust.pattern.prototype;

public class ConcretePrototype1 extends Prototype {

	public ConcretePrototype1() {
		super("实例1");
	}
	
	

	@Override
	public Prototype clone() {
		return (Prototype) this.clone();
	}

}
