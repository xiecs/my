package com.dust.pattern.observer.demo2;

/**
 * 观察者接口简单定义了一个用来更新观察者信息的接口。 当主体对象被更新时，这个接口方法会被自动调用并更新信息。
 */
public interface IObserver {
	/**
	 * 接口方法用来更新观察者的信息。
	 */
	public void remind(ITask taskSubject);
	
	

}
