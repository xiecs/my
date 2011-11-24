package com.dust.pattern.observer.demo1;

import java.util.Observable;


//发布者
public class Product extends Observable {

	private String name;// //产品名
	private float price;// //价格

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		// //设置变化点
		setChanged();
		notifyObservers(name);// //通知观察者
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
		// //设置变化点
		setChanged();
		notifyObservers(new Float(price));
	}

	// //以下可以是数据库更新 插入命令.
	public void saveToDb() {
		System.out.println("saveToDb");
	}

}
