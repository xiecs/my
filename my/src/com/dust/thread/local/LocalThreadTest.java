package com.dust.thread.local;

public class LocalThreadTest {

	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(new Thread1()).start();
		}
	}
}
