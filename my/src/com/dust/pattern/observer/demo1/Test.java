package com.dust.pattern.observer.demo1;

public class Test {

	public static void main(String[] args) {
		Product product = new Product();
		NameObserver nameobs = new NameObserver();

		// //加入观察者
		product.addObserver(nameobs);

		product.setName("applet");
		product.setPrice(9.22f);
	}

}
