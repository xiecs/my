package com.dust.classloader.lock;

import java.net.URL;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyClassLoader1 mycl1;
			MyClassLoader2 mycl2;
			mycl1 = new MyClassLoader1(new URL[] { new URL("file://D://mpay//my//bin//") });
			mycl2 = new MyClassLoader2(new URL[] { new URL("file://D://mpay//my//bin//") }, mycl1);
			
			mycl1.loadClass("com.dust.classloader.lock.package1.A");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
