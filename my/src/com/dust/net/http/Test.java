package com.dust.net.http;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ssss");
		System.out.println(format.format(new Date()));
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 2000; i++) {
				new Thread(new AccessMpayTest()).start();
			}
		}
		System.out.println(format.format(new Date()));
	}

}
