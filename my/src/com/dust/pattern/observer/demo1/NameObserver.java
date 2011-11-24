package com.dust.pattern.observer.demo1;

import java.util.Observable;
import java.util.Observer;

//name观察者
public class NameObserver implements Observer {

	private String name = null;

	public void update(Observable obj, Object arg) {
		if (arg instanceof String) {
			name = (String) arg;
			// //产品名称改变值在name中
			System.out.println("NameObserver :name changet to " + name);
		}
	}
}
