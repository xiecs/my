package com.dust.pattern.observer.demo1;

import java.util.Observable;
import java.util.Observer;

//price观察者
public class PriceObserver implements Observer {

	public void update(Observable o, Object arg) {
		System.out.println("PriceObserver invoke");
	}

}
