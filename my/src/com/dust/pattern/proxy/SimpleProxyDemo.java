package com.dust.pattern.proxy;

public class SimpleProxyDemo {
	
	public static void customer(INTERFACE iface){
		iface.doSometing();
		iface.somethingelse("say hello");
	}

	
	public static void main(String[] args) {
		
		customer(new RealObject());//直接调用
		
		System.out.println("===================");
		
		customer(new SimpleProxy(new RealObject()));//通过代理调用
	}
}
