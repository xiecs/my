package com.dust.pattern.observer.demo2;

/**
 * 主体对象接口定义了注册观察者，取消观察者和通知观察者方法。
 * 
 */
public interface ISubject {
	/**
	 * 为该主体对象注册一个观察者。
	 */
	public void registerObserver(IObserver observer);

	/**
	 * 从该主体对象中取消一个观察者的注册。
	 */
	public void removeObserver(IObserver observer);

	/**
	 * 通知所有观察者。
	 */
	public void notifyObserver();
}
