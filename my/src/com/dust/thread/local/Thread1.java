package com.dust.thread.local;

public class Thread1 implements Runnable {

	public void run() {
		
		System.out.println(Var.getTraceId());

	}

}
