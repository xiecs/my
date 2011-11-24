package com.dust.thread.pool;

public class Runner implements Runnable {

	private int index = 0;

	public Runner(int index) {
		this.index = index;
	}

	public void run() {

		long time = (long) Math.random() * 1000;

		System.out.println("线程：" + Thread.currentThread().getName() + "目标对象：" + index + ":sleepimg " + time + "ms");

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
