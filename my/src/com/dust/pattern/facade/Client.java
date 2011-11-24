package com.dust.pattern.facade;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//需要依次调用，一是麻烦，二是不安全。
		DrawerOne darwerOne = new DrawerOne();
		DrawerTwo darwerTwo = new DrawerTwo();
		darwerOne.open();
		darwerTwo.open();
	}

}
