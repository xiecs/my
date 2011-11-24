package com.dust.pattern.proxy;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
	
	//为了保持行为的一致性，代理类和委托类通常会实现相同的接口，所以在访问者看来两者没有丝毫的区别。
	//通过代理类这中间一层，能有效控制对委托类对象的直接访问，也可以很好地隐藏和保护委托类对象，同时也为实施不同控制策略预留了空间。
	//Java 动态代理机制以巧妙的方式近乎完美地实践了代理模式的设计理念。
	
	//Java 动态代理机制的出现，使得 Java 开发人员不用手工编写代理类，只要简单地指定一组接口及委托类对象，便能动态地获得代理类。
	//代理类会负责将所有的方法调用分派到委托对象上反射执行，在分派执行的过程中，开发人员还可以按需调整委托类对象及其功能。

	public static void customer(INTERFACE iface) {
		iface.doSometing();
		iface.somethingelse("say hello");
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();
		customer(real);
		System.out.println("==========");

		INTERFACE proxy = (INTERFACE) Proxy.newProxyInstance(INTERFACE.class.getClassLoader(),
				new Class[] { INTERFACE.class }, new DynamicProxyHandler(real));
		customer(proxy);

	}

}
