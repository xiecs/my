package com.dust.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

	public static void main(String[] args) {

		// 线程数为2的线程池，固定可重用
		ExecutorService exec = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 10; i++) {
			Runner runner = new Runner(i);
			exec.execute(runner);
		}

		exec.shutdown();
	}

}
