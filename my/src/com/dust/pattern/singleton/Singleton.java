package com.dust.pattern.singleton;

/**
 * 单例模式 一个类仅有一个实例
 * 
 */
public class Singleton {

	private static Singleton singleton;
	private static final Object syncRoot = new Object();

	private Singleton() {

	}

	// 可以用方法锁定，也可以代码块锁

	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (syncRoot) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

}
