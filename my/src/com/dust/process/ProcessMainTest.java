package com.dust.process;

public class ProcessMainTest {
	
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
		
	}

}
