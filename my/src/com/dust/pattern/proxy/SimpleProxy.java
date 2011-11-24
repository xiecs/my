package com.dust.pattern.proxy;

public class SimpleProxy implements INTERFACE {

	//类似spring的注入，构造函数注入，属性注入
	private INTERFACE proxied;

	public SimpleProxy(INTERFACE proxied) {
		this.proxied = proxied;
	}

	public void doSometing() {
		//保持原有功能不变，可以加入新功能，比如日志等，计算调用时间等
		
		//调用开始
		System.out.println("Proxy doSometing");
		proxied.doSometing();
		//调用结束
	}

	public void somethingelse(String arg) {
		//
		System.out.println("Proxy doSometing" + arg);
		proxied.somethingelse(arg);
	}

}
