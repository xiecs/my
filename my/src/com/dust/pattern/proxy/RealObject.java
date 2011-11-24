package com.dust.pattern.proxy;

public class RealObject implements INTERFACE {

	public void doSometing() {
		System.out.println("doSometing");

	}

	public void somethingelse(String arg) {
		System.out.println("doSometing" + arg);

	}

}
