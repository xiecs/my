package com.dust.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {

	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before calling " + proxy.getClass() + ",method:" + method.getName());
		method.invoke(proxied, args);
		System.out.println("after calling " + method.getName());
		return null;
	}

}
