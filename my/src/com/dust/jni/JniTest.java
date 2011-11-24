package com.dust.jni;

public class JniTest {
	
	static{
		System.loadLibrary("");
	}

	public native void output();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
