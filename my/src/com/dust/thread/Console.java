package com.dust.thread;

public class Console implements Runnable{

	public void run() {
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("我睡醒了。。。");
	}

}
